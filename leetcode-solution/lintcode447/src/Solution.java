/**
 * Given a big sorted array with positive integers sorted by ascending
 * order. The array is so big so that you can not get the length of the
 * whole array directly, and you can only access the kth number by
 * ArrayReader.get(k) (or ArrayReader->get(k) for C++). Find the first
 * index of a target number. Your algorithm should be in O(log k), where
 * k is the first index of the target number.
 * Return -1, if the number doesn't exist in the array.
 *
 * Definition of ArrayReader:
 *
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        //首先找到end的范围,如果第k个数比target小，扩大一倍k的范围
        // Algorithm:
        // 1. get the index that ArrayReader.get(index) >= target in
        //    O(logk)
        // 2. Binary search the target between 0 and index
        int k = 1;
        while (reader.get(k - 1) < target) {
            k = k * 2;
        }
        int start = 0;
        int end = k - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target == reader.get(mid)) {
                end = mid;
            } else if (target < reader.get(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }
}
