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
    //找出所有的path，path上所有node之和等于target，这个path从root出发到
    //任何node，可以用traverse，就是从上到下遍历把所有的节点加一遍看看是否
    //等于target；也可以用divide and conquer，就是计算左子树所有的path，
    //计算右子树所有的path，然后把每一个子树的和加上root.val是否等于target

//traverse
public class Solution {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    //Algorithm: Traverse
    //Use recursion to traverse the tree in preorder, pass with a 
    //parameter "sum" as the sum of each node from root to current node.
    //Put the whole path into resuit if the leaf has a sum equal to target.
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        //定义最终的结果
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
        	return result;
        }
        //定义path
        ArrayList<Integer> path = new ArrayList<>();
        //path加上root的那个值
        path.add(root.val);
        helper(root, path, root.val, target, result);
        return result;
    }
    private void helper(TreeNode root, 
    					ArrayList<Integer> path, 
    					int sum, 
    					int target, 
    					List<List<Integer>> result) {
    	//如果左子树右子树都为空，若各子树的root值与target相等，就把只有
    	//root的path加到结果里
    	if (root.left == null && root.right == null) {
    		if (sum == target) {
    			result.add(new ArrayList<Integer>(path));
    		}
    		return;
    	}
    	//如果左子树不为空，把左子树的root值（即原root的left值）加入path，
    	//
    	if (root.left != null) {
    		path.add(root.left.val);
    		helper(root.left, path, sum + root.left.val, target, result);
    		//下一步就相当于是深度优先搜索path中保存的是当前路径上所有的点
    		//当对这个点的子树中所有的点都处理过后，也就是说对这个点的所有操
    		//作已经结束，要把这个点从当前path中去掉
    		//这就是类似于 回溯算法， 当我们沿着树的路径往下走的时候，比如a
    		//可以走到b和c，那么先从a->b,需要把b加入path中，然后我们回到a了，
    		//需要从a走到c了，所以我们先得把b从path中删除，然后加入c，这样
    		//path就成了[a, c]， 也就是沿着c的道路前进。
    		path.remove(path.size() - 1);
    	}
    	//如果右子树不为空，把右子树的root值（即原root的right值）加入path，
    	//
    	if (root.right != null) {
    		path.add(root.right.val);
    		helper(root.right, path, sum + root.right.val, target, result);
    		//下一步就相当于是深度优先搜索path中保存的是当前路径上所有的点
    		//当对这个点的子树中所有的点都处理过后，也就是说对这个点的所有操
    		//作已经结束，要把这个点从当前path中去掉
    		path.remove(path.size() - 1);
    	}
    }
}