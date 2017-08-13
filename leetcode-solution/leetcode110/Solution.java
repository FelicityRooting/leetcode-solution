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
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // without ResultType
        // balanced tree is defined as a binary tree in which the depth of the
        // two subtrees of every node never differ by more than 1
        // 如果左子树是balanced tree，右子树是balanced tree，左右
        // 子树的深度不超过1，那么整棵树就是balanced tree
        // 下面这句的意思是如果root是平衡的，就return它的depth，如果不是就
        // return -1
        return maxDepth(root) != -1;
    }
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftTree = maxDepth(root.left);
        int rightTree = maxDepth(root.right);
        // 如果左子树或者右子树不平衡或者他们的深度相差比1大，那么不平衡
        if (leftTree == -1 || rightTree == -1 || Math.abs(leftTree - rightTree) 
        > 1) {
            return -1;
        }
        //整棵树的max depth = 左右子树的depth中的最大值 + 1
        return Math.max(leftTree, rightTree) + 1;
    }
}

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

//with ResultType, 当你的函数返回多个参数的时候，你需要ResultType。 如果你的
//算法需要返回的东西，和题目给你的接口需要返回的东西不一样，那么就弄一个helper
//方法。如果你需要返回的东西里用一个int，一个double，或者一个string表示不了，
//需要多个变量，那么就用ResultType。

//class ResultType {int var1, var2;}
class ResultType {
    public boolean isBalanced;
    public int maxDepth;
    public ResultType(boolean isBalanced, int maxDepth) {
        this.isBalanced = isBalanced;
        this.maxDepth = maxDepth;
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     * 介绍什么是ResultType:
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        //判断左右子树是不是balanced
        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1);
        }
        //判断左右子树的depth是否相差小于1
        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new ResultType(false, -1);
        }
        return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }
}