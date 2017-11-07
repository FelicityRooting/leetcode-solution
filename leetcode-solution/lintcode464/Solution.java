public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        //quick-sort法，这种方法就是先选出一个pivot，然后大于等于pivot的数
        //都放右边，小于等于它的都放左边，至于等于的两边都放是为了防止出现所
        //有数都相等的极端情况出现，这样两边可以均匀些。接着，再在左右两边各
        //自再选出各自的pivot继续划分排序
        if (A == null || A.length == 0) {
            return;
        }
        quickSort(A, 0, A.length - 1);
    }
    private void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        //pivot不要选成index，要value，因为同一个index的值会变化，后面有交
        //换
        int pivot = A[(start + end) / 2];
        //pivot不能选A[start] or A[end]，如果是升序和降序会出现最坏情况
        while (left <= right) {
            //left <= right not left < right, 如果写成后者，会出现溢出
            //比如3,2,1,4,5, pivot是1,左边找到不比1小的位置停下来，右边找到
            //不比1大的位置停下来，3和1交换，这时候都在2的位置，继续递归，
            //排1和2，就出现问题了
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            //不符合的，互相交换
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}


