// Binary Tree Postorder Traversal
// Given a binary tree, return the postorder traversal of its nodes' values.

// Example:

// Input: [1,null,2,3]
//    1
//     \
//      2
//     /
//    3

// Output: [3,2,1]
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
// 1. postorder是左右根，to_visit表示还没处理过的数据，visited表示处理过的数据
// 2. while循环，只要to_visit的数据没结束，然后从最后取出一个数，push到visited数组里
// 3. 然后push其左子节点和右子节点到to_visit里
// 4. 再取出最后一个数，即上次取出的数的右子节点，再push到visited中，并找到它的左右子节点push到to_visit中，如此循环
// 5. 最后把visited反转过来，因为不反转的话，前面push进visited的顺序是根右左

function postorderTraversal(root) {
    let to_visit = [];
    let visited = [];
    to_visit.push(root);
    while (to_visit.length > 0) {
        var curr = to_visit.pop();
        if (curr !== null) {
            visited.push(curr.val);
            to_visit.push(curr.left);
            to_visit.push(curr.right);
        }
    }
    visited.reverse();
    return visited;
};