// Same Tree
// Given two binary trees, write a function to check if they are the same or not.

// Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

// Example 1:

// Input:     1         1
//           / \       / \
//          2   3     2   3

//         [1,2,3],   [1,2,3]

// Output: true

// Example 2:

// Input:     1         1
//           /           \
//          2             2

//         [1,2],     [1,null,2]

// Output: false

// Example 3:

// Input:     1         1
//           / \       / \
//          2   1     1   2

//         [1,2,1],   [1,1,2]

// Output: false

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * param {TreeNode} p
 * param {TreeNode} q
 * return {boolean}
 */

//  思路：
//  1. 用Json转换array成string
var isSameTree = function(p, q) {
    return JSON.stringify(p)==JSON.stringify(q)
};

//思路：
// 1. 用递归，先判断p和q是否存在
// 2. 然后判断root根节点是否相等
// 3. 判断p和q的左右子节点是否分别相等，递归
var isSameTree = function(p, q) {
    if (!p && !q) 
        return true;
    if (!p || !q || (p.val !== q.val))
        return false;
    
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
};