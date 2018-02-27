// Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) with a source position, find the shortest path to a destination position, return the length of the route.
// Return -1 if knight can not reached.
// Notice

// source and destination must be empty.
// Knight can not enter the barrier.
// Have you met this question in a real interview?
// Clarification

// If the knight is at (x, y), he can get to the following positions in one step:

// (x + 1, y + 2)
// (x + 1, y - 2)
// (x - 1, y + 2)
// (x - 1, y - 2)
// (x + 2, y + 1)
// (x + 2, y - 1)
// (x - 2, y + 1)
// (x - 2, y - 1)

// Example

// [[0,0,0],
//  [0,0,0],
//  [0,0,0]]
// source = [2, 0] destination = [2, 2] return 2

// [[0,1,0],
//  [0,0,0],
//  [0,0,0]]
// source = [2, 0] destination = [2, 2] return 6

// [[0,1,0],
//  [0,0,1],
//  [0,0,0]]
// source = [2, 0] destination = [2, 2] return -1





/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */


public class Solution {
    /*
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
    }
}
