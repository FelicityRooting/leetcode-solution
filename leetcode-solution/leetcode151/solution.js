// Reverse Words in a String
// Given an input string, reverse the string word by word.

// Example:  

// Input: "the sky is blue",
// Output: "blue is sky the".
/**
 * param {string} str
 * returns {string}
*/

// 思路：
// 1. 活用split，trim，regular expression，reverse，join 
var reverseWords = function(str) {
    return str.trim().split(/\s+/).reverse().join(" ");
};