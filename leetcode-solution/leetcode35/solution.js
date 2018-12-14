// Search Insert Position
// Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You may assume no duplicates in the array.

// Example 1:

// Input: [1,3,5,6], 5
// Output: 2

// Example 2:

// Input: [1,3,5,6], 2
// Output: 1

// Example 3:

// Input: [1,3,5,6], 7
// Output: 4

// Example 4:

// Input: [1,3,5,6], 0
// Output: 0
/**
 * param {number[]} nums
 * param {number} target
 * return {number}
 */

//  思路：
//  1.运用binary search，注意使用Math.floor来限定小数取整，否则会有错误
//  2.套用万能公式，注意第一次判定nums[mid] == target时，要考虑到可能mid的前一个数也等于target的情况
//  所以要往前再进行一次判断

var searchInsert = function(nums, target) {
    if (nums == null || nums.length == 0) {
        return 0;
    }

    let start = 0;
    let end = nums.length - 1;
    while (start + 1 < end) {
        let mid = Math.floor(start + (end - start) / 2);
        if (nums[mid] == target) {
            if (nums[mid - 1] !== nums[mid]) {
                return mid;
            } else {
                end = mid;
            }
        } else if (nums[mid] < target) {
            start = mid;
        } else {
            end = mid;
        }
    }
    if (nums[start] >= target) {
        return start;
    }
    if (nums[end] < target) {
        return end + 1;
    }
    return start + 1;
}
