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
    //定义一个lastNode来装在flatten后的数据
    private TreeNode lastNode = null;
    
    /*
     * @param root: a TreeNode, the root of the binary tree
     * @return: 
     */
    public void flatten(TreeNode root) {
        //write your code here
        //如果我碰到一个节点，那么我就把它的父节点的左孩子改为null，右儿子改
        //为当前节点，递归遍历下去。lastnode指向的是上一个处理的节点，也可以
        //看成是当前要处理的节点在“假链表”中的父节点。
        //flatten左子树，把左子树最下最右的一点，接到右子树的root
        //上，然后把root接到左子树的root前即可
        if (root == null) {
            return; 
        }
        //如果lastNode不是空的，那么把其左子树删光，把其右子树接上原树的root
        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }
        //如果lastNode是空的，那么把其接上原树的root
        lastNode = root;
        //就是在flatten(root.left);, 过程中root.right 发生了改变，在这行
        //lastNode.right = root;，所以我们需要先记录一下right作为临时变量。
        //可以画图看看
        TreeNode right = root.right;
        //再对原树的左子树做同样的事
        flatten(root.left);
        flatten(right); 
    }
}


public class Solution {
     /*
     * @param root: a TreeNode, the root of the binary tree
     * @return: 
     */
    public void flatten(TreeNode root) {
        //首先要理解为什么要Last？因为我们要合并两部分内容，怎么合并的，就是
        //左边的last 后边接上右边的第一个. 所以我们返回的last是用于知道当前
        //展开后的最后一个元素，既然右边的是接在左边的后面，那么右边的存在，
        //不就是最后的一定来自于右边么，如果右边的不存在，那么他来自于左边的
        //最后一个。
        helper(root);
    }
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        //代表左右边的最后一个,分治
        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);
        //只要左边的最后一个不是空的，然后将leftLast接上原树root右边的最开
        //始
        if (leftLast != null) {
            leftLast.right = root.right;
            //root的right一边连上root的left，就是把root的left换到root的right
            //的位置
            root.right = root.left;
            //使左边成为null
            root.left = null;
        }
        //这两个if语句不能换，你可能没有理解这个函数在做什么.首先这个函数返回
        //的是flatten之后链表的最后一个元素，那么如果rightLast 存在，那么当
        //前的最后一个元素就是rightLast，只有不存在的时候，leftLast才可能是
        //最后的元素，也就是前面存在了，后面if语句是否成立无关紧要。后面if语
        //句的存在，依赖于前面的if语句。
        if (rightLast != null) {
            return rightLast;
        }
        if (leftLast != null) {
            return leftLast;
        }
        return root;
    }
}