class Solution:
    """
    @param: :  A list of integers
    @return: A list of unique permutations
    """

    def permuteUnique(self, nums):
        # write your code here
        if len(nums) == 0:
            return [[]]
        if len(nums) == 1:
            return [nums]
        res = []
        for i in range(len(nums)):
            for j in self.permute(nums[:i] + nums[i + 1:]):
                res.append([nums[i] + j])
            return res

# r = [1,2,3,4]
# res = []
# for i in range(len(r)):
#     print(i)
#     print(r[:i])
#     print(r[i + 1:])
#     res.append(r[:i] + r[i + 1:])
#     print(res)

# 递归过程
# nums = [1,2,3]
# res = []
# i = 0
#     j in permute([2,3])
#         i = 0 permute([3]) res = [1,2,3]
#         i = 1 permute([2]) res = [1,3,2]
# i = 1
#     j in permute([1,3])
#         i = 0 permute([3]) res = [2,1,3]
#         i = 1 permute([1]) res = [2,3,1]
# i = 2
#     j in permute([1,2])
#         i = 0 permute([2]) res = [3,1,2]
#         i = 1 permute([1]) res = [3,2,1]
