Definition of TreeNode:
public class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    //在root为根的二叉树中找A，B的LCA
    //如果找到了就返回这个LCA
    //如果只碰到node1，就返回node1
    //如果只碰到node2，就返回node2
    //如果都没有，就返回null
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        //write your code here
        //给了整棵树的root，但是没有给parent的指针,而且假设A,B都在tree里，
        //LCAIII的题目里，AB有可能不在树里
        //整个root为根的tree里，先求左子树里有没有AB的lca，然后求右子树里
        //有没有AB的lca，如果有直接return，如果没有，当A在左子树，B在右子树
        //那对于整棵树来说root就是lca,但是除了如果没有lca，那只能碰到哪个点
        //return哪个点，比如左子树得到了一个非空的node，右子树也得到了非空的
        //node，即A或者B，如果A也没B也没，那只能return null了
        if (root == null || root == A || root == B) {
           return root;
        }
        //分别求左右子树的lca
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        //如果左边和右边都是非空，则返回root
        if (left != null && right != null) {
           return root;
        }
        //如果左边是非空，返回左
        if (left != null) {
           return left;
        }
        //如果右边是非空，返回右
        if (right != null) {
           return right;
        }
        //都是空则返回空
        return null;
    }
}
