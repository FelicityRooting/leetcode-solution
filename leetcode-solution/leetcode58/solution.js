// Length of Last Word
// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

// If the last word does not exist, return 0.

// Note: A word is defined as a character sequence consists of non-space characters only.

// Example:

// Input: "Hello World"
// Output: 5


/**
 * param {string} s
 * return {number}
 */

//  思路：
//  1.trim() 方法会从一个字符串的两端删除空白字符。在这个上下文中的空白字符是所有的空白字
//  符 (space, tab, no-break space 等) 以及所有行终止符字符（如 LF，CR）
//  2.用split按照空格分开
// 3.选取最后一项返回其长度

var lengthOfLastWord = function(s) {
    var s1 = s.trim().split(' ');
    return s1[s1.length - 1].length;
};