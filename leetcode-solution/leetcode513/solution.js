/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * param {TreeNode} root
 * return {number}
 */

//  思路：
//  1. 使用递归
//  2. 用一个helper函数，如果当前level比lowestLevel大，则把当前level赋值给lowestLevel，res也赋值当前的root
//  3. 递归这个root的左右子树

var findBottomLeftValue = function(root) {
    let lowestLevel = 0;
    let res = root.val;
    function helper(root, level) {
        if (!root) return null;
        if (level > lowestLevel) {
            res = root.val;
            lowestLevel = level;
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
    helper(root, 0);
    return res;
};