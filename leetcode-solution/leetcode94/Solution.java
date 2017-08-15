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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> Inorder = new ArrayList<Integer>();
        if (root == null) {
            return Inorder;
        }
        TreeNode current = root;
        while (current != null || !stack.empty()) {
            while (current != null) {
                //按照左右根的原则来，先往stack里放根，然后放左
                stack.push(current);
                current = current.left;
            }
            //取出stack里的数
            current = stack.pop();
            Inorder.add(current.val);
            //放入右边
            current = current.right;
        }
        return Inorder;
    }
}