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
    /*
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
     //用stack
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        //定义三个stack，当前层，下一层和暂时,参考之前类似的题比如107
        Stack<TreeNode> currLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        Stack<TreeNode> temp;
        
        currLevel.push(root);
        boolean normalOrder = true;
        
        while (!currLevel.isEmpty()) {
            ArrayList<Integer> currResult = new ArrayList<>();
            while (!currLevel.isEmpty()) {
                TreeNode head = currLevel.pop();
                currResult.add(head.val);
                if (normalOrder) {
                    if (head.left != null) {
                        nextLevel.push(head.left);
                    }
                    if (head.right != null) {
                        nextLevel.push(head.right);
                    }
                } else {
                    if (head.right != null) {
                        nextLevel.push(head.right);
                    }
                    if (head.left != null) {
                        nextLevel.push(head.left);
                    }
                }
            }
            results.add(currResult);
            temp = currLevel;
            currLevel = nextLevel;
            nextLevel = temp;
            normalOrder = !normalOrder;
            
        }
        return results;
    }
}