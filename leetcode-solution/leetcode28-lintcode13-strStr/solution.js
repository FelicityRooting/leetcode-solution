// Implement strStr()

// Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

// Example 1:

// Input: haystack = "hello", needle = "ll"
// Output: 2

// Example 2:

// Input: haystack = "aaaaa", needle = "bba"
// Output: -1

// 思路：
// 1.直接用indexOf就好，indexOf() 方法可返回某个指定的字符串值在字符串中首次出现的位置。

/**
 * param {string} haystack
 * param {string} needle
 * return {number}
 */
var strStr = function(haystack, needle) {
    return haystack.indexOf(needle);
};