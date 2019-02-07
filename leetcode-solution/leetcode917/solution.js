// Reverse Only Letters

// Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.

 

// Example 1:

// Input: "ab-cd"
// Output: "dc-ba"

// Example 2:

// Input: "a-bC-dEf-ghIj"
// Output: "j-Ih-gfE-dCba"

// Example 3:

// Input: "Test1ng-Leet=code-Q!"
// Output: "Qedo1ct-eeLg=ntse-T!"

/**
 * param {string} S
 * return {string}
 */

//  思路：
//  1.使用two pointer
//  2.从两边交换，如果有遇到非字母的，轮到下一个
//  3.直到two pointer指到了中间
var reverseOnlyLetters = function(S) {
    //如果全是非字母，直接返回s
    if (!/[A-Za-z]/.test(S)) return S;
    let arr = S.split("");
    let left = 0;
    let right = arr.length - 1;
    while (left < right) {
        if (/^[a-zA-Z]$/.test(arr[left]) && /^[a-zA-Z]$/.test(arr[right])) {
            [arr[left], arr[right]] = [arr[right], arr[left]]; 
            left++;
            right--;
        } else {
            if (!(/^[a-zA-Z]$/.test(arr[left]))) {
                left++;
            }
            if (!(/^[a-zA-Z]$/.test(arr[right]))) {
                right--;
            }
        }
    }
    return arr.join("");
};