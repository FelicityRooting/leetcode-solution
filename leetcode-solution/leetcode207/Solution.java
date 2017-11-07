public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return true if can finish all courses or false
     */
    //这道题的本质就是在有向图中检测环。
    //如何来表示一个有向图，可以用边来表示，边是由两个端点组成的，用两个点
    //来表示边

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Write your code here
        //定义二维数组prerequisites来表示这个有向图，一位数组degree来表示每个顶
        //点的入度
        List[] edges = new ArrayList[numCourses];
        int[] degree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        //建立这个有向图,并将入度数组也初始化好
        for (int i = 0; i < prerequisites.length; i++) {
            //prerequisites[i][0]代表prerequisites[i]的起点，
            //prerequisites[i][1]代表prerequisites[i]的终点
            degree[prerequisites[i][0]]++;
            //在edges中的prerequisites[i][1]这个点的后面加入
            //prerequisites[i][0]这个点
            //比如[[1,0],[0,1]],prerequisites[i][0]就是[1,0]中的1,
            //prerequisites[i,1]就是[1,0]中的0,所以[1,0]中，1号课程的入度
            //加1,0号课程写在1号课程后面代表take course 1 you have to 
            //first take course 0
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        //定义一个queue变量，将所有入度为0的点放入队列中，然后再开始遍历队列
        Queue queue = new LinkedList();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        

        int count = 0;
        while (!queue.isEmpty()) {
            int course = (int)queue.poll();
            count++;
            //n可以得到course有多少个前置课
            int n = edges[course].size();
            //从prerequisites里遍历其连接的点，每到达一个新节点，将其入度减一
            for (int i = 0; i < n; i++) {
                //pointer是course的前置课程
                int pointer = (int)edges[course].get(i);
                //因为找到pointer了就把它的入度减去1
                degree[pointer]--;
                //如果此时该点入度为0，则放入队列末尾
                if (degree[pointer] == 0) {
                    queue.add(pointer);
                }
            }
        }
        //直到遍历完队列中所有的值,如果此时count的数量和本来课程的数量一样
        //则是true
        return count == numCourses;
    }
}