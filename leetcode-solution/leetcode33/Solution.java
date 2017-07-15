public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     * 本身可以找到最低点，然后在最低点的左右分别二分找到target，但是这样
     * 要做两次二分，本方法是只做一次二分
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        int mid;
        while (start + 1 < end) {
            //分出一半，找出中点，mid点只有两种可能，位于左半边，形成左边的
            //上升区间和右边的rotated sorted array；位于右半边，形成右边的
            //上升区间和左边的rotated sorted array
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            //如果A[mid]比A[start]大，则左边的上升区间是从start到mid
            } else if (A[start] < A[mid]) {
                //target位于左边的上升区间
                if (A[start] <= target && A[mid] >= target) {
                    end = mid;
                } else {
                    //这样去掉了左边的上升区间，右边的还是rotated
                    //sorted array
                    start = mid;
                }
            //如果A[mid]比A[end]小，则右边的上升区间是从mid到end
            } else if (A[end] > A[mid]) {
                //target位于右边的上升区间
                if (A[end] >= target && A[mid] <= target) {
                    start = mid;
                } else {
                    //这样去掉了右边的上升区间，左边的还是rotated
                    //sorted array
                    end = mid;
                }
            }
        }
        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }
}