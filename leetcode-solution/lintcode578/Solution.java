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
//使用resulttype
class ResultType {
	//用一个ResultType来记录ab是否在子树里面，以及LCA node
	//如果不用resultType，那么如果A在，B不在，我们遇到A后，return A，则最后
	//的LCA是A，实际上B是不存在的，这种情况下不用result type将出错
	public boolean a_exist;
	public boolean b_exist;
	public TreeNode node;
	ResultType(boolean a_exist, boolean b_exist, TreeNode node) {
		this.a_exist  = a_exist;
		this.b_exist = b_exist;
		this.node = node;
	}
}
public class Solution {
    /**
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        //如果AB不在tree里,除此之外与lca那题一样
        //定义出口，root为空，或者ab都不存在时返回空
    	ResultType rt = helper(root, A, B);
    	//如果都存在，要么返回root，否则返回空
    	if (rt.a_exist && rt.b_exist) {
    		return rt.node;
    	} else {
    		return null; 
    	}
    }

    public ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
    	//如果A或者B在root上，那么LCA就在root上
    	if (root == null) {
    		return new ResultType(false, false, null);
    	}
    	ResultType left = helper(root.left, A, B);
    	ResultType right = helper(root.right, A, B);

    	//a_exist,b_exist代表以当前节点为根节点的树，是否含有需要寻找的节点A
    	//和B,一个节点存在于某棵树中有3种情况：左子树含有这个节点；右子树含有
    	//这个节点；根节点就等于这个要寻找的节点。通过三个值的或运算：
    	//left.a_exist || right.a_exist || root == A，就可以知道以此结点
    	//为根节点的树里是否含有要寻找的节点A了
    	//AB存在的条件
    	boolean a_exist = left.a_exist || right.a_exist || root == A;
    	boolean b_exist = left.b_exist || right.b_exist || root == B;
    	//如果A,B都在root，证明LCA在root
    	if (root == A || root == B) {
    		return new ResultType(a_exist, b_exist, root);
    	}
    	//如果左右子树都非空
    	if (left.node != null && right.node != null) {
    		return new ResultType(a_exist, b_exist, root);
    	}
    	//如果只有左边有LCA，那么LCA就在左边
    	if (left.node != null) {
    		return new ResultType(a_exist, b_exist, left.node); 
    	}
    	//如果只有右边有LCA，那么LCA就在右边
    	if (right.node != null) {
    		return new ResultType(a_exist, b_exist, right.node);
    	}
    	//最后递归结束后，需要判断是否A和B都存在
    	return new ResultType(a_exist, b_exist, null);
    }
}