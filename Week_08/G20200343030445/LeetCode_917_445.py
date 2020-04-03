#
# @lc app=leetcode.cn id=917 lang=python3
#
# [917] 仅仅反转字母
#

# @lc code=start
class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        i = 0
        j = len(S) - 1
        arr = [text for text in S]
        # print(arr)
        while i < j:
            # print(i, j)
            while not arr[i].isalpha() and i < j:
                i += 1
            while not arr[j].isalpha() and i < j:
                j -= 1
            
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1
        return "".join(arr)
            
        
# @lc code=end

