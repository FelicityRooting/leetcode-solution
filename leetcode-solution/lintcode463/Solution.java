public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        // Write your code here
        // 暴力循环法
        int temp;
        if (A.length <= 1) {
            return;
        } else {
            for (int i = 0; i < A.length; i++) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[i] >= A[j]) {
                        temp = A[i];
                        A[i] = A[j];
                        A[j] = temp;
                    }
                }
            }
        }
    }
}
