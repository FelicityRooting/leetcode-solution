// Count and Say
// The count-and-say sequence is the sequence of integers with the first five terms as following:

// 1.     1
// 2.     11
// 3.     21
// 4.     1211
// 5.     111221

// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.

// Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
// Example 1:

// Input: 1
// Output: "1"

// Example 2:

// Input: 4
// Output: "1211"
/**
 * param {number} n
 * return {string}
 */

//  思路：
//  1.使用递归思想，因为第n项是由第n-1项计算出的
//  2.使用到了`${}`
//  3.基本思路是，逐步计算同一个数字的个数，存到count里，然后把这个count和其对应的数字存在solution里
//  4.for循环里，不用i++，而用i + count来跳过已经数过的数字

var countAndSay = function(n) {
    // 使用递归的思想
    if (n === 1) {
        return "1";
    }
    return getResult(countAndSay(n - 1));
};

//从前一个结果里得到后一个结果
function getResult(prev) {
    let solution = "";
    for (let i = 0; i <= prev.length - 1;) {
        let count = 1;
        const item = prev.charAt(i);
        while (item === prev.charAt(i + count)) {
            count += 1;
        }
        //你可以把任何合法的JavaScript表达式嵌入到占位符中将其作为字符串的一部分输出到结果中。占位符${expression}中间可以包含任意的JavaScript表达式。
        solution += `${count}${item}`;
        i = i + count;//跳过已经数过的数字
    }
    return solution;
}