// Sqrt(x)
// Implement int sqrt(int x).

// Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

// Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

// Example 1:

// Input: 4
// Output: 2

// Example 2:

// Input: 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since 
//              the decimal part is truncated, 2 is returned.
/**
 * param {number} x
 * return {number}
 */

//  思路：
// 1.使用binary search，找出x的一半处，判断其平方后是否等于x

var mySqrt = function(x) {
    if (x == 1) {
        return 1;
    }
    let start = 0;
    let end = x - 1;
    while (start + 1 < end) {
        let mid = Math.floor(start + (end - start) / 2);
        let mul = mid * mid;
        if (mul == x) {
            return mid;
        } else if (mul > x) {
            end = mid;
        } else {
            start = mid;
        }
    }
    let s1 = start * start;
    let e1 = end * end;
    if (s1 <= x && e1 >= x) {
        return start;
    }
    return end;
};
