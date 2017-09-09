/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    //deep copy和非deep copy
    //path = [1,2]
    //List<Intger> newPath = new ArrayList<>(path);
    //path.add(3);  
    //path是[1,2,3]，newPath是[1,2]

    //List<Integer> newPath = path;
    //path.add(3);
    //path是[1,2,3]，newPath是[1,2,3]
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        //有两种方法：1.先clone node -> 再clone edges
        //2. 一边clone node -> 一边 clone edges
        //一般选择第一种，能分开做的不要合在一起做，容易出错
        //先用BFS算法通过node找到其他所有的点
        //node -> nodes
        //nodes -> new nodes
        //edges -> new nodes
    	if (node == null) {
    		return node;
    	}
    	//use bfs algorithm to traverse the graph and get all nodes
    	ArrayList<UndirectedGraphNode> nodes = getNodes(node);
    	//copy nodes, store the old->new mapping information in a hash map
    	//把每个node new一下，然后把新老node的关系存在一个mapping里
    	HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
    	for (UndirectedGraphNode n : nodes) {
    		mapping.put(n, new UndirectedGraphNode(n.label));
    	}
    	//copy neighbors(edges)
    	//先for所有的点
    	for (UndirectedGraphNode n : nodes) {
    		//这里的mapping只是一个映射，表示n这个节点对应的新的节点是
    		//newNode，并没有改变创造的node，而是做了一个映射关系。因为
    		//Java里面是引用传递,改变了newNode，就相当于是改变了
    		//mapping.get(n)
    		UndirectedGraphNode newNode = mapping.get(n);
    		//然后for所有的边
    		for (UndirectedGraphNode neighbor : n.neighbors) {
    			UndirectedGraphNode newNeighbor = mapping.get(neighbor);
    			newNode.neighbors.add(newNeighbor);
    		}
    	}
    	return mapping.get(node);
    }

    //标准的BFS算法
    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
    	Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    	Set<UndirectedGraphNode> set = new HashSet<>();

    	queue.offer(node);
    	set.add(node);
    	while (!queue.isEmpty()) {
    		UndirectedGraphNode head = queue.poll();
    		for (UndirectedGraphNode neighbor : head.neighbors) {
    			if (!set.contains(neighbor)) {
    				set.add(neighbor);
    				queue.offer(neighbor);
    			}
    		}
    	}
    	return new ArrayList<UndirectedGraphNode>(set);
    }
}