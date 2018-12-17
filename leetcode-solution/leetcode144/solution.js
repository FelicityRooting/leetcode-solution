// Binary Tree Preorder Traversal
// Given a binary tree, return the preorder traversal of its nodes' values.

// Example:

// Input: [1,null,2,3]
//    1
//     \
//      2
//     /
//    3

// Output: [1,2,3]
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * param {TreeNode} root
 * return {number[]}
 */

// 思路：
// 1. 前序遍历的顺序是根左右，这里利用stack的先进后出规则
// 2. 先取出数组root的第一个数，push到res数组里，如果这个数的右子节点存在，则存入stack中
// 3. 然后如果这个数的左子节点存在，也存入stack中
// 4. 继续把stack的头一个数push到res数组里（这时候就是左子节点被存入res了）
// 5. 把左子节点取出，看看它有没有左右子节点，在unshift到stack里
// 6. 循环
function preorderTraversal(root) {
    var res = [];
    if (!root) {
        return res;
    }
    var stack = [root];
    while (stack.length > 0) {
        var item = stack.shift();
        res.push(item.val);
        if (item.right) {
            stack.unshift(item.right);
        }
        if (item.left) {
            stack.unshift(item.left);
        }
    }
    return res;
};
