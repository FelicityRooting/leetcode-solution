class Solution:
    """
    @param s: A string
    @return: Whether the string is a valid palindrome
    """
    def isPalindrome(self, s):
        # write your code here
        # Python isalpha() 方法检测字符串是否只由字母组成。
        # Python isdigit() 方法检测字符串是否只由数字组成。
        # 二分法，看左右两边是否一样
        start = 0
        end = len(s) - 1
        while start < end:
            # 如果不是数字也不是字母而是标点，跳过
            while start < end and not s[start].isalpha() and not s[start].isdigit():
                start += 1
            while start < end and not s[end].isalpha() and not s[end].isdigit():
                end -= 1
                # 如果不是标点，则比较两边的是否相同
            if start < end and s[start].lower() != s[end].lower():
                return False
            start += 1
            end -= 1
        return True

