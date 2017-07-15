public class Solution {
    /**
     * @param nums a mountain sequence which increase firstly and then decrease
     * @return then mountain top 
     * Maximum Number in Mountain Sequence
     * Given a mountain sequence of n integers which increase firstly and 
     * then decrease, find the mountain top.
     */
	// Example
	// Given nums = [1, 2, 4, 8, 6, 3] return 8
	// Given nums = [10, 9, 8, 7], return 10

    public int mountainSequence(int[] nums) {
    	//根据判断，保留下有解的一般或者去掉无解的一半
    	//一个山型的序列，top点的左边是递增，右边是递减
    	//所以是找第一个下降的数
    	if (nums == null || nums.length == 0) {
    		return -1;
    	}
    	int start = 0;
    	int end = nums.length - 1;
    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if (nums[mid] < nums[mid + 1]) {
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}
    	if (nums[start] < nums[end]) {
    		return nums[end];
    	} else {
    		return nums[start];
       	}
    }
}