public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     *  Search a 2D Matrix II 
     */
    // Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
    // Integers in each row are sorted in ascending from left to right.
    // Integers in each column are sorted in ascending from top to bottom.
    // No duplicate integers in each row or column.
    // For example,
    // Consider the following matrix: 
    // [
    //   [1, 3, 5, 7],
    //   [2, 4, 7, 8],
    //   [3, 5, 9, 10]
    // ]

    // Given target = 3, return 2.
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        // 从左下角和右上角出发，比如例子中第一行的1,3,5,7，如果要找的target是3，那么与最大的7相比，7
        // 比3打，7那一列的数都比7大，所以可以把7的一整列都给删了，下一列5比3也
        // 大，那么5那一列也可以删除，再下一列3是要找的数，那么计数器可以加1，这
        // 时，3的左边一行都可以不用看了，因为都比3小，3的那一列下面的也不用看了
        // 因为都比3大，只剩下第二行的2和第三行的3,2比3小，舍掉，3加入
        if (matrix == null || matrix.length == 0 || matrix[0] == null || 
        matrix[0].length == 0) {
            return 0;
        }
        //从左下角出发
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        int x = m - 1;
        int y = 0;
        while (x >= 0 && y < n) {
            //比target小，往右移一格
            if (matrix[x][y] < target) {
                y++;
            //比target大，往上移一格
            } else if (matrix[x][y] > target) {
                x--;
            //正好是target，往上和往右移一格, 计数器加一
            } else {
                count++;
                y++;
                x--;
            }
        }
        return count;
    }
}
