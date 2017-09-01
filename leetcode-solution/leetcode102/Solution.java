/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
//Given a binary tree, return the level order traversal of its 
//nodes' values. (ie, from left to right, level by level).
// Example

// Given binary tree {3,9,20,#,#,15,7},

//     3
//    / \
//   9  20
//     /  \
//    15   7
//图的遍历（层级遍历）。注：树是图的一种特殊形态，树属于图
//BFS Key Points
//1.使用queue作为和主要的data structure,如果用stack，会按照倒过来的顺序
//添加，如果不在乎同一层的先后顺序，对于这道题没关系，但是对于其他的一些
//问题，就可能会出现问题,stack主要用来DFS
//2.需要分层的算法比不分层的算法多一个循环
//3.size=queue.size()


public class Solution {
    /*
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    //root是第一层，第二层是第一层的kid，第三层是第二层的kid
    //动态数组的原理是，一旦格子不够用了，就开辟新的更长的格子，把老格子里的数据
    //copy到新格子里，老格子的指针指向新格子，老格子就被delete
    //循环数组circular array，动态数组vector, dynamic array相关知识，用来
    //解决数组实现queue
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
        	return results;
        }

        //interface
        Queue<TreeNode> queue = new LinkedList<>(); 
        queue.offer(root);//把root放入queue中
        //BFS
        //当queue不为空
        while(!queue.isEmpty()) {
        	ArrayList<Integer> level = new ArrayList<>();
        	//只要queue不空，层级遍历就没有结束，for当前层，expand下一层
        	//取出当前层的size
        	int size = queue.size();
        	//for这个size
        	//如果写成 for (int i = 0; i < queue.size(); i++) ,就会发现
        	//结果一直在同一层，因为i < queue.size()这句话每次循环都会
        	//执行一遍，有offer那么queue.size()会变化
        	for (int i = 0; i < size; i++) {
        		//取出一个值
        		TreeNode head = queue.poll();
        		level.add(head.val);
        		if (head.left != null) {
        			queue.offer(head.left);
        		}
        		if (head.right != null) {
        			queue.offer(head.right);
        		}
        	}
        	results.add(level);
        }
        return results;
    }
}