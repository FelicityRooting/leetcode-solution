/**
 * Definition of ParentTreeNode:
 *
 * class ParentTreeNode {
 *     public int val;
 *     public ParentTreeNode parent, left, right;
 * }
 */



// Give a binary tree, and a target number, find all path that the sum of nodes equal to target, the path could be start and end at any node in the tree.
// Have you met this question in a real interview?
// Example

// Given binary tree:

//     1
//    / \
//   2   3
//  /
// 4

// and target = 6. Return :

// [
//   [2, 4],
//   [2, 1, 3],
//   [3, 1, 2],
//   [4, 2]
// ]



public class Solution {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        // Write your code here
        //这题和前面几题不一样的地方在于可以拐弯，比如从3到1到2到4，但是这种拐弯都是
        //只有一次，这个问题的关键在于拐点在哪
    }
}
