// To Lower Case
// Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

 

// Example 1:

// Input: "Hello"
// Output: "hello"

// Example 2:

// Input: "here"
// Output: "here"

// Example 3:

// Input: "LOVELY"
// Output: "lovely"

/**
 * param {string} str
 * return {string}
 */
// 思路：
// 1. 如果不让直接用，可以用正则表达式加上ascel码
var toLowerCase = function(str) {
    return str.toLowerCase();
};