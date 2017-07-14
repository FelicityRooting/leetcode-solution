public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     * Suppose an array sorted in ascending order is rotated 
     * at some pivot unknown to you beforehand. 
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * Find the minimum element. 
     * You may assume no duplicate exists in the array.
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        //nums第二个断层中的最后一个数
        int target = nums[nums.length - 1];
        //find the first element <= target
        //first position <= last number
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] > target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] <= target) {
            return nums[start];
        } else {
            return nums[end];
        }
        //return -1;
    }
}