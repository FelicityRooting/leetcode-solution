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
//Traverse + Divide Conquer

public class Solution {
    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    private class ResultType {
    	public int sum, size;
    	public ResultType (int sum, int size) {
    		this.sum = sum;
    		this.size = size;
    	}
    }

    private TreeNode subtree = null;
    private ResultType subTreeResult = null;

    public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
        //与minimum subtree的做法很像,根据那张图里，要比较sumA/sizeA和
        //sumB/sizeB谁大，就看他们交叉相乘后，若sumA*sizeB > sizeA*sumB,
        //那么A的average大    
        helper(root);
        return subtree;    
    }
    private ResultType helper(TreeNode root) {
    	if (root == null) {
    		return new ResultType(0, 0);
    	}
    	ResultType left = helper(root.left);
    	ResultType right = helper(root.right);
    	ResultType result = new ResultType(left.sum + right.sum + root.val, 
    		left.size + right.size + 1);
    	if (subtree == null || result.sum * subTreeResult.size > 
    		result.size * subTreeResult.sum) {
    		subtree = root;
    		subTreeResult = result;
    	}
    	return result;
    }
}