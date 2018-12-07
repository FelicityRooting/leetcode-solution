// Valid Palindrome
// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

// Note: For the purpose of this problem, we define empty string as valid palindrome.

// Example 1:

// Input: "A man, a plan, a canal: Panama"
// Output: true

// Example 2:

// Input: "race a car"
// Output: false

/**
 * param {string} s
 * return {boolean}
 */

//  思路：
//  1.把string正向和反向各转成没有其他符号的string
//  2.比对两个是否完全一样
//  3.split() 方法用于把一个字符串分割成字符串数组。
//  4.split()的时候，多个空格当成一个空格；split(' ')的时候，多个空格也要分割，会分割出来空。
//  5.join() 方法用于把数组中的所有元素放入一个字符串。元素是通过指定的分隔符进行分隔的。

var isPalindrome = function(s) {
    var s1 = s.replace(/[^a-zA-Z0-9]/g, "").toLowerCase().split('').reverse().join();
    var s2 = s.replace(/[^a-zA-Z0-9]/g, "").toLowerCase().split('').join();
    if (s1 == s2) {
        return true;
    } else {
        return false;
    }
};

