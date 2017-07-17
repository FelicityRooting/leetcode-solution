public class Solution {
    /** 
     * param nums : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     * Search Insert Position
     * Given a sorted array and a target value, return the index if 
     * the target is found. If not, return the index where it would 
     * be if it were inserted in order. You may assume NO duplicates 
     * in the array.
     */
    // Example
    // [1,3,5,6], 5 → 2
    // [1,3,5,6], 2 → 1
    // [1,3,5,6], 7 → 4
    // [1,3,5,6], 0 → 0
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            //如果是[],9，要求得到结果是0，就把下面的return -1 改成return 0
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else {
            if (nums[start] < target && target < nums[end]) {
                return end;
            } else if (nums[start] > target) {
                return start;
            } else if (nums[end] < target) {
                return end + 1;
            }
        }
        return -1;
    }
}