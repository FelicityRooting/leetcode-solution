# Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

# This is case sensitive, for example "Aa" is not considered a palindrome here.
#  Example

# Given s = "abccccdd" return 7

# One longest palindrome that can be built is "dccaccd", whose length is 7.



class Solution:
    """
    @param s: a string which consists of lowercase or uppercase letters
    @return: the length of the longest palindromes that can be built
    """
    def longestPalindrome(self, s):
        # write your code here
        # 判断是否回文，首先string里单个的字母不能超过一个，其他字母则必须是偶数
        # 找出最长回文，则把偶数的都提取出来并且只提取一个奇数
        result = {}
        # 一个个提取s里的字符，与result里的进行对比，如果已经存在了，就祛除，
        # 比如abccccdd,存到result里的就是{"a":true,"b":true}.
        # 这样result里的就全是奇数
        for a in s:
            if a in result:
                del result[a]
            else:
                # d[k]，key in d:键值key是否在d中，是返回True，否则返回False。
                # 这里如果a不在result里，则把a添加进result
                result[a] = True
        b = len(result)
        # # 如果b大于0，
        if b > 0:
            # 将result里奇数的数量减小到1个
            b -= 1
        return len(s) - b


