/**
 * Created by fl222 on 2017/7/12.
 * 问题描述：
 * Find the last position of a target number in a sorted array. Return -1 if target does not exist.
 * Example
 * Given [1, 2, 2, 4, 5, 5].
 * For target = 2, return 2.
 * For target = 5, return 5.
 * For target = 6, return -1.
 * 由此建立二分法的模板：
 * start = 0
 * end = nums.length - 1
 * while (start + 1 < end)
 */
public class solution {
    public int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        //end在前，因为问的是last的位置
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}
