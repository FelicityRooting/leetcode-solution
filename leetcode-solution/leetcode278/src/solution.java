/**
 * Created by Felicity on 2017/3/23.
 */
/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether
 * the kth code version is bad or not.
 */
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if (n == 0) {
            return -1;
        }
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            //如果mid坏了，那就往前找，如果mid没坏，那就往后找
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        //找到最后剩下start和end，哪个坏了用哪个
        if (SVNRepo.isBadVersion(start)) {
            return start;
        }
        return end;
    }
}

