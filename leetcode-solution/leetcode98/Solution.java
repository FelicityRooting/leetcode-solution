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

// version 1 Traverse
public class Solution {
    /*
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    // write your code here
    //BST：左子树都比根节点小，右子树都不小于根节点，中序遍历是不下降序列
    //如果一棵二叉树的中序遍历不是不下降序列，则一定不是BST，如果一棵二叉树
    //中序遍历是不下降也不一定是BST
    //traverse的做法是比较他的中序遍历的每个节点和上一个节点相比是不是大
    //对于中序遍历，firstNode是所有结点中的第一个结点，lastVal是当前结点的
    //上一个该访问结点的值，对于BST，中序遍历是递增的序列，所以判断的是，如果
    //当前结点不是第一个被访问的结点（中序遍历），那么所有的结点的上一个结
    //点都应该比当前结点小
    //BST的一个充要条件就是中序遍历一定是一个非降序的序列。或者可以这样
    //想：在处理一棵子树时，首先处理了root.left ，然后root，最后root.right，
    //这和root.left < root <= root.right是相符的。在处理完一棵子树后，
    //lastNode指向root.right, 而当前处理的节点指向了root的父节点，又保证了
    //一个节点所有左子树中的节点都小于父节点
    private int lastVal = Integer.MIN_VALUE; 
    //firstNode只是用来标记当前是否是第一个节点，因为第一个节点没有lastVal
    //这个值。       
    private boolean firstNode = true;
    public boolean isValidBST(TreeNode root) {
        //root只要是空，当前的tree就是BST    
        if (root == null) {
            return true;
        }   
        //如果左子树不是BST，返回false
        if (!isValidBST(root.left)) {
            return false;
        }
        //当前节点不是第一个被访问的点，lastVal是当前结点的上一个该访问结点的
        //值，这里的root.val是当前访问到的结点，而且上一个结点比当前节点大的
        //话，返回false
        if (!firstNode && lastVal >= root.val) {
            return false;
        }
        //现在不是firstnode了
        firstNode = false;
        //接下来要访问下一个结点，所以lastval要被赋予当前结点了
        lastVal = root.val;
        //如果右子树不是BST，返回false
        if (!isValidBST(root.right)) {
            return false;
        }
        //都不是，返回true
        return true;
    }
}


// version 2  Divide and Conquer with resultType
public class Solution {
    /*
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    // 左子树的最大比根结点小，右子树的最小比根结点大
    public boolean isValidBST(TreeNode root) {

    }
}

// version 2  Divide and Conquer without resultType