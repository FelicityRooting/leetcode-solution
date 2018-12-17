// Two Sum II - Input array is sorted
// Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

// The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

// Note:

//     Your returned answers (both index1 and index2) are not zero-based.
//     You may assume that each input would have exactly one solution and you may not use the same element twice.

// Example:

// Input: numbers = [2,7,11,15], target = 9
// Output: [1,2]
// Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

// 思路：
// 1. 先在一个数组做一个for loop遍历，并且把target - numbers[i]作为target传入binary search的code里
// 2. 找到答案后返回当时的i和答案的index值
// 3. 如果有相等的数，要做一次处理，直接返回i + 1和i + 2

/**
 * param {number[]} numbers
 * param {number} target
 * return {number[]}
 */

//思路：
// 1.用two pointer，first pointer的numbers数组里binary search
// 2.找target减去second pointer的numbers数组，记录正好为0的数，传入数组
var twoSum = function(numbers, target) {
    function findNext(start, end, target) {
        while (start + 1 < end) {
            let mid = Math.floor(start + (end - start) / 2);
            if (target == numbers[mid]) {
                return mid;
            } else if (target > numbers[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (target == numbers[start]) {
            return start;
        }
        if (target == numbers[end]) {
            return end;
        }
    }
    for (let i = 0; i <= numbers.length - 1; i++) {
        let result = findNext(0, numbers.length - 1, target - numbers[i]);
        if ((numbers[result] + numbers[i]) == target) {
            if (numbers[result] == numbers[i]) {//如果数组里出现有相同的数，而target可以由这两个相同的数相加得到
                return [i + 1, i + 2];
            }
            return [i + 1, result + 1];
        }
    }
    
};