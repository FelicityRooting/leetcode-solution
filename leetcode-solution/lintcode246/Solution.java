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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // Write your code here
        //和它的编号为I的那题很像，但是不需要从根到叶，只是一定要从上到下
        //首先求出所有从根开始的路径的和，在某一条路径里找到所有的起始到终止，比
        //如[1,2,4]，那就是[1,2],[2,4],[4],[1]等等。如果用分治的思想，分为几个
        //情况：path全在左子树的，path全在右子树的，以及从root出发加下来直到加到
        //target
        //The path does not need to start or end at the root or a leaf, but 
        //it must go in a straight line down.这句话是解题的关键
        //      1
        //     / \
        //    2   3
        //   /   /
        //  4   2
        //那么我们在dfs整个树的过程中，比如当前的路径是1->2->4, 我们把路径存下
        //来是[1,2,4],因为是要连续的，我们从4往上枚举，发现4+ 2 = 6 那么就找
        //到了一条长度为6的路径。也就是本题的方式是，来到某一个点，以他作为最下
        //面的点，沿着路径往上走，去寻找长度为target的路径。
    }
}