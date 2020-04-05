# -*- coding:utf-8 -*-

# @lc app=leetcode.cn id=557 lang=python
#
# [557] 反转字符串中的单词 III
#

# @lc code=start
class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        
        arr = s.split()
        def reverse(str, i, j):
            while i < j:
                str[i],str[j] = str[j],str[i]
                i += 1
                j -= 1
            return str
            
        for i,s1 in enumerate(arr):
            s1 = list(s1)
            temp = reverse(s1, 0, len(s1)-1)
            arr[i] = "".join(temp)
        
        return " ".join(arr)
    
    
# @lc code=end

if __name__ == "__main__":
    obj = Solution()
    ret = obj.reverseWords("Let's take LeetCode contest")
    if ret == "s'teL ekat edoCteeL tsetnoc":
        print("reverse success")
    else:
        print("reverse failed")
    
