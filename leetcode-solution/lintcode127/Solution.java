/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
//拓扑排序本质上是找到一个合理的顺序去使得这个顺序前面的点不会依赖于后面的点
//拓扑排序的做法是非常典型的BFS
//入度(indegree)和出度的概念：如果从A->B，那么A的出度+1，B的入度+1
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> order = new ArrayList<>();
        if (graph == null) {
        	return order;
        }
        //所以第一步，统计入度count indegree
        Map<DirectedGraphNode, Integer> indegree = getIndegree(graph);
        
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        
        //第二步，BFS，把那些indegree为0的放入order（因为可能不止一个点是
        //起点）
        for (DirectedGraphNode node : graph) {
        	if (indegree.get(node) == 0) {
        		queue.offer(node);
        		order.add(node);
        	}
        }
        //第三步，从queue中找出一个可以先走的点，让它走掉
        while (!queue.isEmpty()) {
        	//先取出一个indegree为0的点
        	DirectedGraphNode node = queue.poll();
        	
        	//打个比方，从九章基础到九章强化班，要先解锁九章基础班，完成
        	//这个解锁的过程就是接下来要做的事
        	for (DirectedGraphNode neighbor : node.neighbors) {
        		//node -> neighbor
        		//继续之前的比方，完成解锁就是把0的点从graph里删除，那么这个
        		//点对应的边也被删除了，于是要把这些边指向的点的入度减一
        		indegree.put(neighbor, indegree.get(neighbor) - 1);
        		//一旦那些点的入度变成0了，那就可以加到queue里了
        		if (indegree.get(neighbor) == 0) {
        			queue.offer(neighbor);
        			order.add(neighbor);
        		}
        	}
        }

        if (order.size() == graph.size()) {
        	//如果相等，那么原graph存在循环依赖，变成一个1->2,2->3,3->1的
        	//循环graph，所以可以拓扑排序
        	return order;
        }
        return null;
    }
    private Map<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph) {
    	Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
    	for (DirectedGraphNode node : graph) {
    		//所有的node的入度先设为0
    		indegree.put(node, 0);
    	}

    	for (DirectedGraphNode node : graph) {
    		//对于每一个node，如果它有下一个指向的点
    		for (DirectedGraphNode neighbor : node.neighbors) {
    			//node -> neighbor
    			//把一个node的下一个指向的点的入度加1
    			indegree.put(neighbor, indegree.get(neighbor) + 1);
    		}
    	}
    	return indegree;
    }
}


public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> map = new HashMap();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1); 
                }
            }
        }
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                q.offer(node);
                result.add(node);
            }
        }
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode n : node.neighbors) {
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) {
                    result.add(n);
                    q.offer(n);
                }
            }
        }
        return result;
    }
}