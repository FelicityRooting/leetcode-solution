// Longest Common Prefix
// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

// Example 1:

// Input: ["flower","flow","flight"]
// Output: "fl"

// Example 2:

// Input: ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.

// Note:

// All given inputs are in lowercase letters a-z.
/**
 * param {string[]} strs
 * return {string}
 */

//  思路：
//  1.先给strs排个序，这样最短并且按字母表排前的就会在strs[0]
//  2.把strs[0]的每一项拿出来和后面的每个string的每一项比对
//  3.如果有不一样的，用slice来获取相同的部分

var longestCommonPrefix = function(strs) {
    if (!strs || strs.length === 0) return ''
    //先给字符串排序,找到strs[0]为最短并且按字母排序最靠前的
    strs.sort();

    let prefix = strs[0];//先假设prefix为strs[0]
    //这里如果用str in strs，就不对了,str不是strs里的每一项，而变成了index
    for (let str of strs) {
        //最长前缀字符串肯定要小于最短字符串长度，所以先找到最短字符串的长度，再按序遍历字符串数组，
        //出现后不匹配项，直接return输出。
        for (let i = 0; i <= prefix.length - 1; i++) {
            if (str[i] !== prefix[i]) {
                prefix = str.slice(0,i)
                break;
            }
        }
    }
    return prefix;
};