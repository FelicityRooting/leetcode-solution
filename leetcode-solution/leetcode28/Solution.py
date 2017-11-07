class Solution:
    """
    @param: source: source string to be scanned.
    @param: target: target string containing the sequence of characters to match
    @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
    """
    def strStr(self, source, target):
        # write your code here
        if source is None or target is None:
            return -1
        return source.find(target)
    # Python find() 方法检测字符串中是否包含子字符串 str ，如果指定 beg（开始）
    # 和 end（结束） 范围，则检查是否包含在指定范围内，如果包含子字符串返回开始
    # 的索引值，否则返回-1。



# 以下的方法是不用python内置的find()的方法
# class Solution:
#     """
#     @param: source: source string to be scanned.
#     @param: target: target string containing the sequence of characters to match
#     @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
#     """
#     def strStr(self, source, target):
#         # write your code here
#         if source is None or target is None:
#             return -1
#         for i in range (len(source) - len(target) + 1):
#             if source[i:i + len(target)] == target:
#                 return i
#         return -1
