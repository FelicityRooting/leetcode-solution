class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 0) {
            return false;
        }
        
        long start = 1;
        long end = num;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (start * start == num) {
            return true;
        } else if (end * end == num) {
            return true;
        } else {
            return false;
        }
    }
}