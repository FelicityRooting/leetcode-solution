# Python的类的方法和普通的函数有一个很明显的区别，在类的方法必须有个额外的第一个参数(self)，但在调用这个方法
# 的时候不必为这个参数赋值(显胜于隐的引发）。Python的类的方法的这个特别的参数指代的是对象本身，而按照Python
# 的惯例，它用self来表示。（当然我们也可以用其他任何名称来代替，只是规范和标准在那建议我们一致使用self）

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
