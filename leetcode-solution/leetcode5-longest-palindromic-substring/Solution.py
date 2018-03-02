# Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
# Have you met this question in a real interview?
# Example

# Given the string = "abcdzdcab", return "cdzdc".


class Solution:
    """
    @param s: input string
    @return: the longest palindromic substring
    """
    def longestPalindrome(self, s):
        # write your code here
        res = ""
        # helper是用来在每一个点上从里到外找是否回文的
        for i in range(len(s)):
            # 奇数, like "aba"
            tem = self.helper(s, i, i)
            if len(tem) > len(res):
                res = tem
            # 偶数, like "abba"
            tem = self.helper(s, i, i + 1)
            if len(tem) > len(res):
                res = tem
        return res
    # 从里到外
    def helper(self, s, l, r):
        while l >= 0 and r < len(s) and s[l] == s[r]:
            l -= 1
            r += 1
        return s[1+l:r]
