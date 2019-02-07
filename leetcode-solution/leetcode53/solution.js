// Maximum Subarray
// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

// Example:

// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.

/**
 * param {number[]} nums
 * return {number}
 */
// 思路：
// 1. 如果全是负数，sum就是所有数字里最大的负数, 如果全是正数，sum就是所有数字之和
// 2. 遍历nums，加每一项到sum里，如果sum大于maxn，就maxn=sum，如果sum小于0，sum归零
// 3. 最后输出maxn
var maxSubArray = function(nums) {

    var sum = 0;
    var maxn = -Number.MAX_VALUE;
    for (let i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (sum > maxn) maxn = sum;
        //当sum为负数，就归零，这样下一轮加的时候，又从0开始
        if (sum < 0) sum = 0;
    }
    return maxn;
};