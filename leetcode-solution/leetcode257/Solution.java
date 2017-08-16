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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        //遍历的过程中记录之前的path，一旦遍历到叶子节点便将该path加入结果中
        ArrayList<String> paths = new ArrayList<String>();
        if (root == null) {
            return paths;
        }
        //左子树的path
        List<String> leftPath = binaryTreePaths(root.left);
        //右子树的path
        List<String> rightPath = binaryTreePaths(root.right);
        //记录之前的path
        for (String path : leftPath) {
            paths.add(root.val + "->" + path);
        }
        for (String path : rightPath) {
            paths.add(root.val + "->" + path);
        }
        //if root is a leaf
        if (paths.size() == 0) {
            paths.add("" + root.val);
        }
        return paths;
    }
}