class Solution:
    """
    @param: nums: A set of numbers.
    @return: A list of lists. All valid subsets.
    """
    # 2**len(nums)是包含nums里的所有元素的子集个数
    # >> 是右位移运算符
    def subsetsWithDup(self, nums):
        # write your code here
        res = [[]]
        nums.sort()
        for i in range(len(nums)):
            # if S[i] is same to S[i - 1], then it needn't to be added to all of the subset, just add it to the last l subsets which are created by adding S[i - 1]
            if i == 0 or nums[i] != nums[i - 1]:
                # "l" was the number of subsets created by the last s[j] where s[j] != s[j-1].
                l = len(res)
            for j in range(len(res) - l, len(res)):
                res.append(res[j] + [nums[i]])
                #不明白的可动笔画一画
        return res
