public class Solution {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        // write your code here
        // 这个问题在面试中不会让实现完整程序
    	// 只需要举出能够最坏情况的数据是 [1,1,1,1... 1] 里有一个0即可。
	    // 在这种情况下是无法使用二分法的，复杂度是O(n),因此写个for循环最坏
	    // 也是O(n)，那就写个for循环就好了如果你觉得，不是每个情况都是最坏
	    // 情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。反正
	    // 面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到
	    // 最坏情况。
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == target) {
        		return true;
        	}
        }
        return false;
        
    }
}