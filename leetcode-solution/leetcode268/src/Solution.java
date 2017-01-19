/**
 * Created by Felicity on 2017/1/17.
 */
//最直观的一个方法是用等差数列的求和公式求出0到n之间所有的数字
// 之和，然后再遍历数组算出给定数字的累积和，然后做减法，差值就是丢失的那个数字，
public class Solution {
    public int missingNumber(int[] nums) {
        int count = 0;
        for (int i = 0; i<nums.length; i++) {
            count = count + nums[i];
        }
        int sum = (1+nums.length)*nums.length/2;
        int missNumber = sum-count;

        return missNumber;
    }
}
