public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array II
     * Suppose an array sorted in ascending order is rotated at some 
     * pivot unknown to you beforehand.(i.e., 0 1 2 4 5 6 7 might 
     * become 4 5 6 7 0 1 2).Find the minimum element.The array may 
     * contain duplicates.
     */
// public class Solution {
//     public int findMin(int[] num) {
//         //这道题目在面试中不会让写完整的程序
//         //只需要知道最坏情况下 [1,1,1....,1] 里有一个0
//         //这种情况使得时间复杂度必须是 O(n)
//         //因此写一个for循环就好了。
//         //如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情
//         //况的情况，那你就写一个二分吧。
//         //反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想
//         //得到最坏情况。
//         int min = num[0];
//         for (int i = 1; i < num.length; i++) {
//             if (num[i] < min)
//                 min = num[i];
//         }
//         return min;
//     }
// }
    public int findMin(int[] num) {
        // write your code here
        // 参考lintcode159
        if (num == null || num.length == 0) {
            return -1;
        }
        int start = 0, end = num.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] == num[end]) {
                // if mid equals to end, that means it's fine to remove end
                // the smallest element won't be removed
                end--;
            } else if (num[mid] < num[end]) {
                end = mid;
            } else if (num[mid] > num[end]) {
                start = mid;
            }
        }
        if (num[start] <= num[end]) {
            return num[start];
        } 
        return num[end];
    }
}