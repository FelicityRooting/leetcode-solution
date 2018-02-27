/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *  Given a binary tree and a sum, determine if the tree has a
 * root-to-leaf path such that adding up all the values along the path
 * equals the given sum. For example: Given the below binary tree and
 * sum = 22,
 *            5
 *           / \
 *          4   8
 *         /   / \
 *        11  13  4
 *       /  \      \
 *      7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which
 * sum is 22.
 */
//自己想的方法是套用leetcode113，加上一个对result长度的判定
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return false;
        }
        ArrayList<Integer> path = new ArrayList<>();
        helper(root, path, root.val, sum, result);
        if (result.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
    private void helper(TreeNode root,
                       ArrayList<Integer> path,
                       int sum1,
                       int sum,
                       List<List<Integer>> result) {
        if (root.left == null && root.right == null) {
            if (sum1 == sum) {
                path.add(root.val);
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }
        if (root.left != null) {
            path.add(root.left.val);
            helper(root.left, path, sum1 + root.left.val, sum, result);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            helper(root.right, path, sum1 + root.right.val, sum, result);
            path.remove(path.size() - 1);
        }
    }
}

//官方答案
public class Solution {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return sum == root.val;
		}
		return hasPathSum (root.left, sum - root.val)
		|| hasPathSum(root.right, sum - root.val);
	}
}


