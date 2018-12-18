// Binary Tree Paths
// Given a binary tree, return all root-to-leaf paths.

// Note: A leaf is a node with no children.

// Example:

// Input:

//    1
//  /   \
// 2     3
//  \
//   5

// Output: ["1->2->5", "1->3"]

// Explanation: All root-to-leaf paths are: 1->2->5, 1->3
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * param {TreeNode} root
 * return {string[]}
 */

//  思路：
//  1. 使用递归
//  2. 如果node存在，则加入到path中
//  3. 如果node没有左右子节点，则直接把path给push到result中，如果有，加入->
//  4. 对存在的左右子节点做递归findPath()

var binaryTreePaths = function(root) {
    var result = [];
    if (!root) {
        return [];
    }
    function findPath(node, path) {
        if (!node) {
            return;
        } else {
            path = path + node.val;
        }
        if (!node.left && !node.right) {
            return result.push(path);
        } else {
            path = path + "->";
        }
        if (node.left) {
            findPath(node.left, path);
        }
        if (node.right) {
            findPath(node.right, path);
        }
    }
    findPath(root, "");
    return result;
}