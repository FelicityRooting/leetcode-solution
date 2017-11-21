class Solution:
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums = sorted(nums)#就差这一步很关键，除了这里，其他的和permutation那题一样
        if len(nums) == 0:
            return [[]]
        if len(nums) == 1:
            return [nums]
        res = []
        for i in range(len(nums)):
            for j in self.permuteUnique(nums[:i] + nums[i + 1:]):
                res.append([nums[i]] + j)
        return res
