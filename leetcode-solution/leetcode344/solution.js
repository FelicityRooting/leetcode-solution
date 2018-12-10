// Reverse String
// Write a function that takes a string as input and returns the string reversed.

// Example 1:

// Input: "hello"
// Output: "olleh"

// Example 2:

// Input: "A man, a plan, a canal: Panama"
// Output: "amanaP :lanac a ,nalp a ,nam A"

// 思路：
// 1.把string用split分开后，reverse，再拼回去

/**
 * param {string} s
 * return {string}
 */
var reverseString = function(s) {
    return s.split('').reverse().join('');
};
