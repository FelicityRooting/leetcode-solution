// Invert Binary TreeInvert a binary tree.

// Example:

// Input:

//      4
//    /   \
//   2     7
//  / \   / \
// 1   3 6   9

// Output:

//      4
//    /   \
//   7     2
//  / \   / \
// 9   6 3   1
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * param {TreeNode} root
 * return {TreeNode}
 */

//  思路：
//  1. 递归
//  2. 关键在于[root.left, root.right] = [root.right, root.left];交换左右子节点
function invertTree(root) {
    if (!root) {
        return null;
    }
    [root.left, root.right] = [root.right, root.left];
    invertTree(root.left);
    invertTree(root.right);
    return root;
}