// Binary Tree Inorder Traversal
// Given a binary tree, return the inorder traversal of its nodes' values.

// Example:

// Input: [1,null,2,3]
//    1
//     \
//      2
//     /
//    3

// Output: [1,3,2]

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
// 思路：
// 1. inorder是左根右，如果root还有值，或者stack的长度不为0，进入while循环
// 2. 在while循环里，如果root还有值，把root值push到空的stack里，并用root的左子节点取代root
// 3. 如果在while循环里，root没了，则表示上一个root没有左子节点了，所以从stack把上一个root取出并push到res空数组里
// 4. 此时从stack取出的root是整棵树最左边的节点
// 5. 用root的右子节点取代root，返回去执行while循环，来看这个root的右子节点有没有左子节点
/**
 * param {TreeNode} root
 * return {number[]}
 */
var inorderTraversal = function(root) {
    let res = [];
    let stack = [];
    while(root || stack.length) {
        if(root) {
            stack.push(root);
            root = root.left;
        } else {
            root = stack.pop();
            res.push(root.val);
            root = root.right;
        }
    }
    return res;
};
//递归版本
var inorderTraversal = function(root) {
    let res = new Array();
    if(!root) {
        return res;
    }
    if (root.left) {
        res = res.concat(inorderTraversal(root.left));
    }
    // res = res.concat(root.val);
    res.push(root.val);
    if (root.right) {
        res = res.concat(inorderTraversal(root.right));
    }
    return res;
}