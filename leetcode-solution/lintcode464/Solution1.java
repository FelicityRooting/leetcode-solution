public class Solution1 {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        //使用merge sort
        if (A == null || A.length == 0) {
            return;
        }
        //把用来同数的temp放在外面new，然后作为参数传入mergeSort，这样
        //不用每次都去new
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
    }
    private void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        //排序左边
        mergeSort(A, start, (start + end) / 2, temp);
        //排序右边
        mergeSort(A, (start + end) / 2 + 1, end, temp);
        //合并
        merge(A, start, end, temp);
    }

    private void merge(int[] A, int start, int end, int[] temp) {
        int middle = (start + end) / 2;
        int leftIndex = start;
        int rightIndex = middle + 1;
        int index = leftIndex;
        while (leftIndex <= middle && rightIndex <= end) {
            //将左右子集的值相互比较
            if (A[leftIndex] <= A[rightIndex]) {
                temp[index++] = A[leftIndex++];
            } else {
                temp[index++] = A[rightIndex++];
            }
        }
        //可能有一边比较长，这时候要继续比较
        while (leftIndex <= middle) {
            temp[index++] = A[leftIndex++];
        }
        while (rightIndex <= end) {
            temp[index++] = A[rightIndex++];
        }
        
        //把temp里排好的数放到原来的A数组里
        for (int i = start; i <= end; i++) {
            A[i] = temp[i];
        }
    }
}