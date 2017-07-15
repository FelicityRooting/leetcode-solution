public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        //先二分一下在哪个行，然后再二分一下在哪个列
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 
        || matrix[0] == null) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row - 1;
        //分一下在哪个行
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        //找到行以后细化在哪个列
        if (matrix[end][0] == target || matrix[start][0] == target) {
            return true;
        } else if (matrix[start][0] < target && matrix[end][0] > target) {
            int start1 = 0;
            int end1 = col - 1;
            while (start1 + 1 < end1) {
                int mid1 = start1 + (end1 - start1) / 2;
                if (matrix[start][mid1] == target) {
                    return true;
                } else if (matrix[start][mid1] < target) {
                    start1 = mid1;
                } else {
                    end1 = mid1;
                }
            }
            if (matrix[start][start1] == target) {
                return true;
            } else if (matrix[start][end1] == target) {
                return true;
            } else {
                return false;
            }
        } else {
            int start2 = 0;
            int end2 = col - 1;
            while (start2 + 1 < end2) {
                int mid2 = start2 + (end2 - start2) / 2;
                if (matrix[end][mid2] == target) {
                    return true;
                } else if (matrix[end][mid2] < target) {
                    start2 = mid2;
                } else {
                    end2 = mid2;
                }
            }
            if (matrix[end][start2] == target) {
                return true;
            } else if (matrix[end][end2] == target) {
                return true;
            } else {
                return false;
            }
        }
    }
}
