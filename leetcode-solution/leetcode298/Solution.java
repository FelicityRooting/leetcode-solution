/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    //定义最长值
    private int longest;
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        // Write your code here
        //可以分别求左右子树分别最长连续是多少，然后看root能不能接上左右子树
        //在每一个节点找对应的最优的长序列
        longest = 0;
        helper(root);
        return longest;
    }

    private int helper(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	//分别求左右子树的最长连续序列的长度
    	int leftLong = helper(root.left);
    	int rightLong = helper(root.right);
    	int subtreeLongest = 1;//at least we have root;
    	//如果左子树不为空而且root的值+1=root左边一个数的值(这样root能接上
    	//左子树的值），那么subtreeLongest就是subtreeLongest和左子树的最
    	//长连续序列的长度加1中最大的那一个（因为要加上root的那个1点长度）
    	if (root.left != null && root.val + 1 == root.left.val) {
    		subtreeLongest = Math.max(subtreeLongest, leftLong + 1);
    	}
    	//如果右子树不为空而且root的值+1=root右边一个数的值(这样root能接上
    	//右子树的值），那么subtreeLongest就是subtreeLongest和右子树的最
    	//长连续序列的长度加1中最大的那一个（因为要加上root的那个1点长度）
    	if (root.right != null && root.val + 1 ==root.right.val) {
    		subtreeLongest = Math.max(subtreeLongest, rightLong + 1);
    	}
    	//得到subtreeLongest后与longest比较
    	if (subtreeLongest > longest) {
    		longest = subtreeLongest;
    	}
    	return subtreeLongest;
    }
}