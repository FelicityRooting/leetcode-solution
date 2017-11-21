class Solution:
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums = sorted(nums)#就差这一步很关键，少了就出错
        if len(nums) == 0:
            return [[]]
        if len(nums) == 1:
            return [nums]
        res = []
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            for j in self.permuteUnique(nums[:i] + nums[i + 1:]):
                res.append([nums[i]] + j)
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
# nums = [3,3,0,3]
# res = []
# i = 0
#     j in permute([3(2),0,3(3)])
#         i = 0 permute([0,3(3)])
#               i = 0 permute([3(3)]) res = [3(1),3(2),0,3(3)] = 3,3,0,3
#               i = 1 permute([0]) res = [3(1),3(2),3(3),0] = 3,3,3,0
#         i = 1 permute([3(2),3(3)])
#               i = 0 permute([3(3)]) res = [3(1),0,3(2),3(3)] = 3,0,3,3
#               i = 1 permute([3(2)]) res = [3(1),0,3(3),3(2)] = 3,0,3,3 (drop)
#         i = 2 permute([3(2),0])
#               i = 0 permute([0]) res = [3(1),3(3),3(2),0] = 3,3,3,0
#               i = 1 permute([3(2)]) res = [3(1),3(3),0,3(2)] = 3,3,0,3
# i = 1
#     j in permute([1,2(2)])
#         i = 0 permute([2(2)]) res = [2(1),1,2(2)] = [2,1,2]
#         i = 1 permute([1]) res = [2(1),2(2),1] = [2,2,1]
# i = 2
#     j in permute([1,2(1)])
#         i = 0 permute([2(1)]) res = [2(2),1,2(1)] = [2,1,2]
#         i = 1 permute([1]) res = [2(2),2(1),1] = [2,2,1]
