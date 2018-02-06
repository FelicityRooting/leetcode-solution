class Solution:

    """
    @param: nums: A set of numbers
    @return: A list of lists
    """
    # 不明白的拿笔画画就明白了
    def subsets(self, nums):
        res = [[]]
        nums.sort()
        for i in nums:
            res += [j + [i] for j in res]
        return res
