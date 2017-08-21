/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ResultType {
    public int maxlength;
    public int maxup;
    public int maxdown;
    ResultType (int length, int up, int down) {
        maxlength = length;
        maxup = up;
        maxdown = down;
    } 
} 
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive2(TreeNode root) {
        // Write your code here
        //与I的题稍微不同的地方在于，路径可以在任意一点开始和结束
        return helper(root).maxlength;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int down = 0, up = 0;
        //max_down记录的是，以当前结点为出发点，比该点小的 组成的连续序列最长
        //的长度,max_up记录的是，以当前结点为出发点，比该点大的
        //组成的连续序列最长的长度这几行是为了计算 比当前结点大的连续序列的
        //最长长度 和 比当前结点小的连续序列的最长长度
        //左下
        if (root.left != null && root.left.val + 1 == root.val) {
            down = Math.max(down, left.maxdown + 1);
        }
        //左上
        if (root.left != null && root.left.val - 1 == root.val) {
            up = Math.max(up, left.maxup + 1);
        }
        //右下
        if (root.right != null && root.right.val + 1 == root.val) {
            down = Math.max(down, right.maxdown + 1);
        }
        //右上
        if (root.right != null && root.right.val - 1 == root.val) {
            up = Math.max(up, right.maxup + 1);
        }
        //之前并没有算入进去，初始化的时候： down, up = 0, 0,
        //如果这个是叶子节点，那么所有if语句不成立，返回的down
        //,up都是0，所以down和up是不包含root的。
        int length = down + 1 + up;
        length = Math.max(length, Math.max(left.maxlength, right.maxlength));
        return new ResultType(length, up, down);
    }
}