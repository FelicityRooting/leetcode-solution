// Sum of Left Leaves
// Find the sum of all left leaves in a given binary tree.

// Example:

//     3
//    / \
//   9  20
//     /  \
//    15   7

// There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
/*
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
//  2. 判断左子节点是否是叶子节点，如果是，加上到res
//  3. 如果不是，对左子节点做递归
//  4. 对右子节点做递归

var sumOfLeftLeaves = function(root) {
    let res = 0;
    if (!root) {
        return res;
    }
    if (root.left && root.left.left === null && root.left.right === null) {
        res += root.left.val;
    } else {
        res += sumOfLeftLeaves(root.left);
    }
    if (root.right) {
        res += sumOfLeftLeaves(root.right);
    }
    return res;
};