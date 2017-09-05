/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 链表题中经常会遇到这样的问题：链表的第一个node，因为没有前驱节点，所以该node
// 需要特殊处理，会导致额外的代码量。如果创建一个dummy，将其作为第一个node的前驱
// 节点，这样链表中所有的node都可以也能够同样的逻辑来处理了.
// 这个程序里面head是不断在移动着的。head = dummy 这句之后，就意味着dummy成了新
// 的head。接下来楼主看，后面循环里根据不同情况判断head1和head2的大小，
// head.next = head1 或者 head.next = head2, 实际上就是从dummy这个node开始
// 的。这就是楼上的前辈说的，用dummy把头结点记录下来的意思。
// dummy始终记录的是合并后链表头的前驱节点，是静态的。而head记录的是合并过程中
// 最新merge进来的节点, 是动态的。lz可以脑补一下拉链

public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> results = new ArrayList<ListNode>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        //dummy仿制品
        //比如dummy 是 内存块A的名字（就跟人名一样，张三李四）head是内存块B
        //的名字（你可以通过名字找到内存块）
        //dummy.next = head 就是 A中的next域存了B的名字
        //head = dummy 就相当于A的内存块，有多了一个新名字叫做head，这个名
        //字给别人用了，B就不能再用了，这时候通过head就不能找到原来的内存块
        //了，A就好比一个人有多个名字了。
        //要避开的误区是，比如说你给了张三一个苹果，现在我们把张三这个名字给
        //另外一个人A用了，那么显然你没有给现在的张三一个苹果。
        //好比 head = dummy，那么dummy的next变化了么，显然没有变化。
        //如果是让head = XXX, 这样dummy是不会变的，因为是让head指向了另外
        //的东西。如果是让head.next = XXX, 这样dummy是会变的，因为现在head
        //和dummy还是指向的同一个东西。
        //让head=dummy,head改变的时候,dummy不会跟着改变
        //想象head 和dummy是两个指针，他们指向同一地址，head改变，是这个指
        //针本身变了，他指向的值和指针dummy并不会变

        //建立一个dummy node使得它next指向linked list的第一个node
        ListNode dummy = new ListNode(0);
        ListNode lastNode = null;
        while (!queue.isEmpty()) {
            //dummy的next域指向null
            dummy.next = null;
            //lastNode指针指向dummy
            lastNode = dummy;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                lastNode.next = new ListNode(node.val);
                lastNode = lastNode.next;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //此时的dummy.next指的是linkedlist的第一个node
            results.add(dummy.next);
        }
        return results;
    }
}