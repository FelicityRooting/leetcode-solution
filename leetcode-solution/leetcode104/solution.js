// Maximum Depth of Binary Tree
// Given a binary tree, find its maximum depth.

// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

// Note: A leaf is a node with no children.

// Example:

// Given binary tree [3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7
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

// 思路：
// 1. 使用recursive DFS
// 2. 一开始用root和max做node和depth
// 3. 如果node有值，max为max和depth里的最大值
// 4. 如果node无值，对左子节点做DFS，depth + 1是因为如果根结点只有左子树而没有右子树，那么树的深度应该是其左子树的深度加1；同样如果根结点只有右子树而没有左子树，那么树的深度应该是其右子树的深度加1
// 5. 对右子节点也同样做DFS
var maxDepth = function(root) {
    let max = 0;
    const DFS = (node = root, depth = max) => {
        if (node == null) {
            max = Math.max(max, depth);
            return;
        }
        DFS(node.left, depth + 1);
        DFS(node.right, depth + 1);
    }
    DFS();
    return max;
};