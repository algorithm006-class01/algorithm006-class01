'''
541. 反转字符串 II
给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。

示例:

输入: s = "abcdefg", k = 2
输出: "bacdfeg"

要求:

1. 该字符串只包含小写的英文字母。
2. 给定字符串的长度和 k 在[1, 10000]范围内。

'''
class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        ret = collections.deque()
        substring = collections.deque()
        counter = 0
        to_reverse = True
               
        for letter in s:
            counter += 1
                       
            if (to_reverse):
                substring.appendleft(letter)
            else:
                substring.append(letter)
                               
            if (counter == k):
                to_reverse = not to_reverse
                ret += substring
                substring.clear()
                counter = 0
                     
        if (len(substring)):
            ret += substring
       
        return "".join(ret)