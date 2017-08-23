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
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // write your code here
        //方法一：递归。这道题可以用递归的方法，一个节点一个节点的把每个节点遍
        //历一遍，并且在遍历的同时记录每个节点相对应的层数，然后求出叶子节点当
        //中的最小层数就是我们所求的答案。
        //方法二：非递归。非递归的方法也就是用宽度优先搜索一层一层树上去遍历节
        //点，当第一次遍历到树上的叶子节点的时候就是我们所要找到的二叉树的最小
        //深度。
        if (root == null) {
            return 0;
        }
        //这一步可以加上也可以不加
        // if (root.left == null && root.right == null) {
        //     return 1;
        // }
        //求的是最小，所以左边是空的话，返回右边，右边亦然
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}