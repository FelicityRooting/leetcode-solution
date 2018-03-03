class Solution:
    """
    @param: A: an integer array sorted in ascending order
    @param: target: An integer
    @return: an integer
    Given a target number and an integer array A sorted in ascending order, find the index i
    in A such that A[i] is closest to the given target.
    Return -1 if there is no element in the array.

    Given [1, 2, 3] and target = 2, return 1.

    Given [1, 4, 6] and target = 3, return 1.

    Given [1, 4, 6] and target = 5, return 1 or 2.

    Given [1, 3, 3, 4] and target = 2, return 0 or 1 or 2.
    """
    def closestNumber(self, A, target):
        # write your code here
        # 二分法
        if not A:
            return -1
        start = 0
        end = len(A) - 1
        while start + 1 < end:
            #python 2是/，python 3改成//整除
            mid = start + (end - start) // 2
            if A[mid] == target:
                return mid
            elif A[mid] > target:
                end = mid
            else:
                start = mid

        if A[end] - target > target - A[start]:
            return start
        else:
            return end


