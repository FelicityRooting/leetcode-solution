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
    public int maxDepth(TreeNode root) {
        // write your code here
        // divide and conquer
        // 整棵树的max depth = 左右子树的depth中的最大值 + 1
        if (root == null) {
            return 0;
        }
        
        int leftTree = maxDepth(root.left);
        int rightTree = maxDepth(root.right);
        int maxDepth = Math.max(leftTree, rightTree) + 1;
        return maxDepth;
    }
}