// Reverse Words in a String III
// Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

// Example 1:

// Input: "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
/**
 * param {string} s
 * return {string}
 */
var reverseWords = function(s) {
    return s.split('').reverse().join('').split(' ').reverse().join(' ');
};

var reverseWords = function(s) {
    return s.split(" ").map(str => 
        str.split("").reverse().join("")
        ).join(" ");
}