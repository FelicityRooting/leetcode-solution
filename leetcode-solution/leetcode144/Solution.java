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
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        // 非递归版本,使用stack,先放右边再放左边因为stack是先进后出的结构
        // https://www.youtube.com/watch?v=elQcrJrfObg看这个视频可以有更好的
        // 理解，拿     1    举例
        //            / \
        //           2   3
        //          / \
        //         4   5
        // 先把 1放入stack，然后输出1，再把3放入stack， 把2放入stack，输出2，再把
        // 5放入stack，把4放入stack，输出4再输出5，最后输出3
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> preorder = new ArrayList<Integer>();
        
        if (root == null) {
            return preorder;
        }
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            preorder.add(node.val);
            //使用stack,先放右边再放左边因为stack是先进后出的结构
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return preorder;
        
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        /*递归版本
         *整个的过程是，先把root作为参数放入result里，然后把root的左子树放到
         * result里，再把root的右子树放到result里
         */
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    //result本身作为参数传入
    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;//如果root为空，则中断返回
        }
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        //分治法，这时候不再把result作为参数传入，而是作为返回值
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        //divide
        //先把左子树的前序遍历找出
        ArrayList<Integer> left = preorderTraversal(root.left);
        //再把右子树的前序遍历找出
        ArrayList<Integer> right = preorderTraversal(root.right);
        //conquer
        result.add(root.val);
        //把左子树的遍历加入result
        result.addAll(left);
        //把右子树的遍历加入result，如果是后序遍历，则反过来一遍
        result.addAll(right);
        return result;
        
    }
}

