// Flatten Binary Tree to Linked List
// Given a binary tree, flatten it to a linked list in-place.

// For example, given the following tree:

//     1
//    / \
//   2   5
//  / \   \
// 3   4   6

// The flattened tree should look like:

// 1
//  \
//   2
//    \
//     3
//      \
//       4
//        \
//         5
//          \
//           6

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * param {TreeNode} root
 * return {void} Do not return anything, modify root in-place instead.
 */
// 思路：
// 1. 用前序遍历遍历出原tree
// 2. root.left将root的左子树设为null
// 3. cursor这时候得到了左子树为空的root
// 4. for循环list里的用前序遍历得到的root
// 5. cursor的右子节点设为每次list里的一项（这里如果不用treenode，无法放到cursor里，因为cursor里的是一个树
// 6. 然后将cursor的根节点设为其右子节点，这样循环，就能把list里的每一项一次一次地接在右子节点后面
var flatten = function(root) {
    if (!root) {
        return [];
    }
    let list = [];
    DFS(root, list);
    root.left = null;
    let cursor = root;
    for (let i = 1; i <= list.length - 1; i++) {
        cursor.right = new TreeNode(list[i].val);
        cursor = cursor.right;
    }
};

//preorder traversal;
function DFS (root, list) {
    if (!root) {
        return [];
    }
    list.push(root);
    if (root.left) {
        DFS(root.left, list);
    }
    if (root.right) {
        DFS(root.right, list);
    }
    return list;
}