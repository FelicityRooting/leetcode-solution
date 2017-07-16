public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     * Total Occurrence of Target
     * Given a target number and an integer array sorted in ascending 
     * order. Find the total number of occurrences of target in the 
     * array.
     */
	// Example

	// Given [1, 3, 3, 4, 5] and target = 3, return 2.

	// Given [2, 2, 3, 4, 6] and target = 4, return 1.

	// Given [1, 2, 3, 4, 5] and target = 6, return 0.
	/*与给的答案不同，这里是类似于search for range那道题，先做两次二分法，找到
     * target的两个边界，然后用两个边界的位置相减再加一。如果边界是[-1, -1]，那
     * 就直接结果是0
     */

    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if (A.length == 0 || A == null) {
            return 0;
        }
        int start, end, mid;
        int[] bound = new int[2];
        //left bound;
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[start] == target) {
            bound[0] = start;
        } else if (A[end] == target) {
            bound[0] = end;
        } else {
            bound[0] = bound[1] = -1;
        }
        
        //right bound
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            bound[1] = end;
        } else if (A[start] == target) {
            bound[1] = start;
        } else {
            bound[1] = bound[0] = -1;
        }
        if (bound[1] == -1 || bound[0] == -1) {
            return 0;
        }
        return bound[1] - bound[0] + 1;
    }
}