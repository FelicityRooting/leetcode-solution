class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     * Find Peak Element
     */
    // There is an integer array which has the following features:
    // The numbers in adjacent positions are different.
    // A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
    // We define a position P is a peek if:
    // A[P] > A[P-1] && A[P] > A[P+1]
    // Example
    // Given [1, 2, 1, 3, 4, 5, 7, 6]
    // Return index 1 (which is number 2) or 6 (which is number 7)
    public int findPeak(int[] A) {
        // write your code here
        //先增后减必有峰，那么mid处的值，如果它前增后减，那么此处的mid是一个
        //峰值；如果前后都增，那么mid处于一个上升区间，可以把start赋予mid的值；
        //如果前后都减，那么mid处于一个下降区间，可以把end赋予mid的值；如果前
        //减后增，那么mid正好处于最低点，可以把end或者start赋予mid的值
        if (A.length == 0 || A == null) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
                start = mid;
            } else if (A[mid] < A[mid - 1] && A[mid] > A[mid + 1]) {
                end = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }
}
