// Trim a Binary Search Tree
// Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

// Example 1:

// Input: 
//     1
//    / \
//   0   2

//   L = 1
//   R = 2

// Output: 
//     1
//       \
//        2

// Example 2:

// Input: 
//     3
//    / \
//   0   4
//    \
//     2
//    /
//   1

//   L = 1
//   R = 3

// Output: 
//       3
//      / 
//    2   
//   /
//  1

// 思路：
// 1. 用递归
// 2.分三段，如果root在L和R之间，如果root比L小，如果root比R大

var trimBST = function(root, L, R) {
    if (!root) return null;
    if (root.val <= R && root.val >= L) {
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R); 
    } else if (root.val < L) {
        root = trimBST(root.right, L, R);
    } else {
        root = trimBST(root.left, L, R);
    }
    return root;
};