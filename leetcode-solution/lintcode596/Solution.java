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
// traverse + divide conquer
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     * travese + divide conquer
     */
    private TreeNode subtree = null;
    private int subtreeSum = Integer.MAX_VALUE;
    //Integer.MAX_VALUE表示 int 类型能够表示的最大值

    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        // 找子树和最小的一个，return该子树的root, 对于每一个节点，
        // 1. 如果它是空节点，那么就返回0 
        // 2.如果它有左子数，那么加上左子树的和
        // 3. 如果它有右子树，那么加上右子树的和
        // 简单来说，对于任何一个节点，我们不去考虑它下面还有多少儿子，只是考虑
        // 和它直接接触的左儿子和右儿子（如果存在的话）。如果到这个节点为止的
        // 和小于之前的和，那么就更新最小和，以及要回答的节点。
        helper(root);
        return subtree;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = helper(root.left) + helper(root.right) + root.val;
        //如果到这个节点为止的和小于之前的和，那么就更新最小和，以及要回答的
        //节点。
        if (sum <= subtreeSum) {
            subtreeSum = sum;
            subtree = root;
        }
        return sum;
    }
}

//pure divide conquer
class ResultType {
    public TreeNode minSubtree;
    public int minSum;
    public int sum;
    public ResultType (TreeNode minSubtree, int minSum, int sum) {
        this.minSubtree = minSubtree;
        this.sum = sum;
        this.minSum = minSum;
    }
}
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     * pure divide conquer
     */
     // 找子树和最小的一个，return该子树的root, 对于每一个节点，
     // 1. 如果它是空节点，那么就返回0 
     // 2.如果它有左子数，那么加上左子树的和
     // 3. 如果它有右子树，那么加上右子树的和
     // 简单来说，对于任何一个节点，我们不去考虑它下面还有多少儿子，只是考虑
     // 和它直接接触的左儿子和右儿子（如果存在的话）。如果到这个节点为止的
     // 和小于之前的和，那么就更新最小和，以及要回答的节点。
    public TreeNode findSubtree(TreeNode root) {
        ResultType result = helper(root);
        return result.minSubtree;
    }
    public ResultType helper(TreeNode node) {
        if (node == null) {
            return new ResultType(null, Integer.MAX_VALUE, 0);
        }
        ResultType left = helper(node.left);
        ResultType right = helper(node.right);
        //int sum = helper(root.left) + helper(root.right) + root.val
        ResultType result = new ResultType(node, 
            left.sum + right.sum + node.val,
            left.sum + right.sum + node.val);
        if (left.minSum <= result.minSum) {
            result.minSum = left.minSum;
            result.minSubtree = left.minSubtree;
        }
        if (right.minSum <= result.minSum) {
            result.minSum = right.minSum;
            result.minSubtree = right.minSubtree;
        }
        return result;
    }
}