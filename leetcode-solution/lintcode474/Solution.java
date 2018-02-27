/**
 * Definition of ParentTreeNode:
 *
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */

// Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

// The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

// The node has an extra attribute parent which point to the father of itself. The root's parent is null.
// Have you met this question in a real interview?
// Example

// For the following binary tree:

//   4
//  / \
// 3   7
//    / \
//   5   6

// LCA(3, 5) = 4

// LCA(5, 6) = 7

// LCA(6, 7) = 7

public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here
        // 先设定两个node的path来存放其path
        ArrayList<ParentTreeNode> pathA = getPath2Root(A);
        ArrayList<ParentTreeNode> pathB = getPath2Root(B);
        // 得到pathA和pathB的大小
        int indexA = pathA.size() - 1;
        int indexB = pathB.size() - 1;
        // 设定LCA变量
        ParentTreeNode lowestCommonAncestor = null;
        while (indexA >= 0 && indexB >= 0) {
            //把两个节点做笔记，如果不一样，则结束
            if (pathA.get(indexA) != pathB.get(indexB)) {
                break;
            }
            //先把pathA最下面的放入lowestCommonAncestor中
            lowestCommonAncestor = pathA.get(indexA);
            //这样寻找到A的parent，再去循环与B的parent相比较l直到找到LCA
            indexA--;
            indexB--;
        }
        return lowestCommonAncestor;
    }
    private ArrayList<ParentTreeNode> getPath2Root(ParentTreeNode node) {
        ArrayList<ParentTreeNode> path = new ArrayList<>();
        //只要当前的node不为空
        while (node != null) {
            //从下往上把node加入path里
            path.add(node);
            node = node.parent;
        }
        //最终的path里从左到右是从kid到parent的顺序
        return path;
    }
}

