public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     * Closest Number in Sorted Array. 
     * Given a target number and an integer array A sorted in 
     * ascending order, find the index i in A such that A[i] is 
     * closest to the given target. Return -1 if there is no element 
     * in the array.
     */
    // Example

    // Given [1, 2, 3] and target = 2, return 1.

    // Given [1, 4, 6] and target = 3, return 1.

    // Given [1, 4, 6] and target = 5, return 1 or 2.

    // Given [1, 3, 3, 4] and target = 2, return 0 or 1 or 2.

    public int closestNumber(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        //先找到不比target小的数位置
        int index = firstIndex(A, target);
        //查看这个位置，若为0或者A.length - 1，则它的前面或者后面再没有可以
        //与之比较是否是最近的数的，所以直接是0或者A.length - 1。
        if (index == 0) {
            return 0;
        }
        if (index == A.length - 1) {
            return A.length - 1;
        }
        //如果不是，那么判断一下index的数前面的数和index所指的数谁离target最近
        if (target - A[index - 1] < A[index] - target) {
            return index - 1;
        }
        return index;
    }
    private int firstIndex(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if(A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[start] >= target) {
            return start;
        } else if (A[end] >= target) {
            return end;
        }
        return A.length - 1;
    }
}