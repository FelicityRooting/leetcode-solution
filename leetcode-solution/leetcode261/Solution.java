//lintcode178
public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    //一个图是一棵树的条件：两点，第一个是n个点刚好n-1条边，第二个是n个点连通
    //
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        if (n == 0) {
            return false;
        }
        //只要n个点不上刚好n-1条边，直接返回false
        if (edges.length != n - 1) {
            return false;
        }
        //接下来判断连通性
        //以0到n-1为这n个点的编号，可以从任何一个点开始，然后从初始点开始，遍历
        //所有的点，在遍历时，需要知道每个点以及它的邻居，知道了邻居后，邻居点就
        //会成为下一个点，这时候需要去存储这个图。
        //关于如何存储图，一般不用矩阵，因为如果是N个点，那么矩阵是N的平方，太大
        //了，所以一般用邻接表来存储，比如{1, [2,4]}, {2, [1,3])，1的邻居是2和4,
        //2的邻居是1和3，[2,4],[1,3]存成一个set，这样形成了{key, value},此处的
        //value是set of integer
        Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);
        //bfs
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> hash = new HashSet<>();
        //这样才能用for循环简单地循环某一个点的所有邻居
        //在这里由点及面不需要做层级遍历，没有什么for当前层的所有点去扩展下一层
        //的所有点，就是取queue头上的一个点，再把它下面的点都弄进去
        queue.offer(0);
        hash.add(0);//以编号为0的点开始
        
        //1.树
        //首先，我们得了解一下树。树，这种数据结构每个节点有零个或多个子节点；
        //没有父节点的节点称为根节点；每一个非根节点有且只有一个父节点，所以树
        //有一个关键的性质就是n个结点的树有n-1条边。假如题中的边数不是n-1，那么
        //一定不是树
        //2.判断完边后
        //判断完边数之后，这里还需要再思考一个问题，有n-1条边的图一定是树吗？
        //答案是否定的，因为题中并没有说给我们的一定是一个连通图，也就是说，很有
        //可能给我们的图是几个图，所以我们判断完边数之后还得判断是否是一个连通图。
        //3.判断是否为连通图
        //那么现在问题就变成了判断是否为一个连通图，判断连通图的方法在参考程序里
        //给了两种方法，一种是从一个点出发，判断与这个点相连的点数是否等于n,
        //(如果不是联通的，那visit就不等于n)，第二种就是用并查集的方法判断是否
        //联通。
        
        //for example:Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
        while (!queue.isEmpty()) {
            int node = queue.poll();
            //从0开始，node=0，graph里与0相邻的有1,2,所以graph.get(0)是
            //{0,[1,2,3]}
            for (Integer neighbor : graph.get(node)) {
                //neighbor=1,2,3
                //hash里一开始没有这些，如果有就continue
                if (hash.contains(neighbor)) {
                    continue;
                }
                //把0的邻接点1,2,3加到queue里
                queue.offer(neighbor);
                //hash里加上1,2,3,(hash表里加的是从0开始能找到的与每个点相邻
                //的点)
                hash.add(neighbor);
                //加完后，第一次循环结束，由于queue不为空，这时node=1，graph里
                //与1相邻的有0,4，所以graph.get(1)是{1,[0,4]}，再次进入for循环，
                //这次又把0,4加入到了hash中，queue为{2,3,0,4},由于queue不为空，
                //这时node=2,所以graph.get(2)是{2,[0]},再次进入for循环，由于
                //hash里已经有了0，所以直接下次循环，queue为{3,0,4}，这时node=3
                //graph.get(3)是{3,[0]},和上次一样，queue为{0,4},这时node=0，
                //hash里已经有了1,2,3。queue为{4}，node=4，graph.get(4)为{4,[1]}
                //hash里已经有了1，所以最后判断hash的size是否等于n，如果是则输出
                //true，如果不是，则输出false
            }
        }
        return (hash.size() == n);
    }
    
    //构建图
    private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        for (int j = 0; j < edges.length; j++) {
            //edges[i] 表示图中的两个端点，两个端点分别为edges[i][0]和edge[i][1]
            //i表示第几条边，比如i = 1时
            //表示第一条边，这条边有两个端点，这两个点的label是u和v。
            int u = edges[j][0];
            int v = edges[j][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            //edges是二维数组，N行2列，其实表示的是N条边关系，每行是两个节点，
            //他俩组成一条边。u和v是这两个节点，那么v肯定是u的邻接点之一，u也是
            //v的邻接点之一,graph.get(u)是u的邻接点列表，是一个HashSet.那么
            //graph.get(u).add(v)其实是两步：set = graph.get(u), set.add(v),这样
            //就v加到u的邻接表里面了.反过来同理啦
        }
        return graph;
    }
}