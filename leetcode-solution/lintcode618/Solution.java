/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
// 2------3  5
//  \     |  | 
//   \    |  |
//    \   |  |
//     \  |  |
//       1 --4
// Give a node 1, target is 50

// there a hash named values which is [3,4,10,50,50], represent:
// Value of node 1 is 3
// Value of node 2 is 4
// Value of node 3 is 10
// Value of node 4 is 50
// Value of node 5 is 50

// Return node 4
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    //层级遍历，给了点1，找离1最近的值为50的点，先看离1距离是1的点有没有是50的
    //再看距离是2的点有没有50的，以此类推
    //为何不用分层遍历？
    //因为按照bfs去找，先碰到的点距离一定距离最短
    //如何找所有最近的value=target的点，可用分层遍历
    //因为得知道哪些点是在这一层的，碰到了第一个符合的点后，后面还可能有符合
    //的点

    //为什么需要 graph ？ 还有一个原因是 LintCode 需要展示 input数据对吧？
    //我想是为了保证input和参数一致。不用HashSet 也可以，因为大不了有些点重
    //复访问，但是最终我们还是可以访问到所需要的node，但是重复访问影响效率，
    //肯定不如答案好，在面试中，面试官肯定喜欢答案这种有Hashset去掉重复访问
    //的。比如a能访问到b，c也能访问到b，那么下次c到b的时候，b就不需要再次进
    //入queue了。

    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // Write your code here
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        
        queue.offer(node);
        set.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            //如果某个点的value和target一样，就符合
            if (values.get(head) == target) {
                return head;
            }
            for (UndirectedGraphNode neighbor : head.neighbors) {
              //把访问过的点加入set里
                if (!set.contains(neighbor)) {
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }
        return null;
    }
}