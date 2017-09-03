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
 */
//序列化是把“内存”中的结构化的数据变成“字符串”的过程
//serialization is object to string
//deserialization is string to object
//什么时候需要序列化:
//1. 将内存中的数据持久化存储时 内存中重要的数据不能只是呆在内存里，这样断
//电就没有了，所需需要用一种方式写入硬盘，在需要的 时候，能否再从硬盘中读出
//来在内存中重新创建
//2. 网络传输时 机器与机器之间交换数据的时候，不可能互相去读对方的内存。只能
//讲数据变成字符流数据（字符串）后 通过网络传输过去。接受的一方再将字符串解
//析后到内存中。常用的一些序列化手段： • XML • Json • Thrift (by Facebook) 
//• ProtoBuf (by Google)
//序列化算法
//一些序列化的例子： • 比如一个数组，里面都是整数，我们可以简单的序列化为
//”[1,2,3]” • 一个整数链表，我们可以序列化为，”1->2->3” • 一个哈希表(HashMap)，
//我们可以序列化为，”{\”key\”: \”value\”}”
//序列化算法设计时需要考虑的因素： • 压缩率。对于网络传输和磁盘存储而言，当然
//希望更节省。 • 如 Thrift, ProtoBuf 都是为了更快的传输数据和节省存储空间而
//设计的。 • 可读性。我们希望开发人员，能够通过序列化后的数据直接看懂原始数据
//是什么。 • 如 Json，LintCode 的输入数据
//二叉树如何序列化？
//你可以使用任何你想要用的方法进行序列化，只要保证能够解析回来即可。 LintCode 
//采用的是 BFS 的方式对二叉树数据进行序列化，这样的好处是，你可以更为容易的
//自己画出 整棵二叉树。
//算法描述： http://www.lintcode.com/en/help/binary-tree-representation/ 

class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return "{}";
        }
        //用BFS
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);

        //用i<queue.size()因为会随着queue.add变化
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        //除去最后的连着的###########
        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        //形成string
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(queue.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data.equals("{}")) {
            return null;
        }
        //把string从第一位到最后一位，凭借,分开
        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        //root一定是第一个数字
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;
        //和serialization的相反
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
}
