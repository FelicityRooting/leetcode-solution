// earch a 2D Matrix
// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

//     Integers in each row are sorted from left to right.
//     The first integer of each row is greater than the last integer of the previous row.

// Example 1:

// Input:
// matrix = [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// target = 3
// Output: true
/**
 * param {number[][]} matrix
 * param {number} target
 * return {boolean}
 */

// 思路：
// 1.先用for循环找出在matrix里的哪个数组里
// 2.用二分法找出target是否存在

var searchMatrix = function(matrix, target) {
    if (matrix.length == 0 || matrix[0].length == 0) {
        return false;
    }
    function search(matrix, target) {
        let arr = [];
        let start = 0;
        let end = matrix.length - 1;
        while (start + 1 < end) {
            let mid = Math.floor(start + (end - start) / 2);
            if (matrix[mid] == target) {
                console.log(matrix[mid]);
                return true;
            } else if (matrix[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (matrix[start] == target) {
            return true;
        }
        if (matrix[end] == target) {
            return true;
        }
        return false;
    }
    for (let i = 0; i <= matrix.length - 1; i++) {
        var aa = matrix[i][0];
        var bb = matrix[i][matrix[i].length - 1];
        if (aa <= target && bb >= target) {
            return search(matrix[i], target);
        }
    }
    return false;
};