// Roman to Integer
// Example 1:

// Input: "III"
// Output: 3

// Example 2:

// Input: "IV"
// Output: 4

// Example 3:

// Input: "IX"
// Output: 9

// Example 4:

// Input: "LVIII"
// Output: 58
// Explanation: L = 50, V= 5, III = 3.

// Example 5:

// Input: "MCMXCIV"
// Output: 1994
// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

/**
 * param {string} s
 * return {number}
 */

// 思路：
// 从右向左依次处理：当遇到这个字母表示的数字比后一个小的时候，减去这个数；否则，累加。

var romanToInt = function(s) {
    const rules = {
        I: 1,
        V: 5,
        X: 10,
        L: 50,
        C: 100,
        D: 500,
        M: 1000
    };
    var sum = 0;
    for (let i = s.length - 1; i >= 0; i--) {
        const curr = rules[s.charAt(i)];
        const next = rules[s.charAt(i - 1)];
        if (curr > next) {
            sum = sum + curr - next;
            i = i - 1;
        } else {
            sum = sum + curr;
        }
    }
    return sum
};