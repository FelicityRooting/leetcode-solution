// Happy Number
// Write an algorithm to determine if a number is "happy".

// A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

// Example: 

// Input: 19
// Output: true
// Explanation: 
// 1*1 + 9*9 = 82
// 8*8 + 2*2 = 68
// 6*6 + 8*8 = 100
// 1*1 + 0*0 + 0*0 = 1
/**
 * param {number} n
 * return {boolean}
 */

//  思路：
//  1. 用hash表,把每次相加得到的数存入hash表中
//  2. 只要在某次相加后得到的数前面得到过，就是一个死循环，直接return false
//  3. 直到最终的结果为1，return true 

var isHappy = function(n) {
    if (n === 1) return true;
    let obj = {};
    while(n !== 1) {
        let temp = 0;
        while (n !== 0) {
            temp += (n % 10)*(n % 10);
            n = parseInt(n / 10);
        }
        if (obj[temp] === temp) return false;
        if (temp === 1) {
            return true;
        } else {
            n = temp;
            obj[n] = n;
        }
    }
};