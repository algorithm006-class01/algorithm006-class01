# -*-  coding:utf-8 -*-
# @lc app=leetcode.cn id=231 lang=python
#
# [231] 2的幂
#
# 解题思路
# 1.判断有几个位为1,2的冥就是1不断位移的结果
# 2.不断除以2，如果是2的冥最后的结果肯定是1，非2的冥肯定不等于1
# 3.-x等于x的每个位取反 + 1 -x = ~x+1, 
#   -x & x 保留最右边的1，其他位设0
#   2的冥二进制中只有一个1，取反后只有一个0, +1后再与上自己肯定结果是自己
#   -x & x = x 表示这个数是2的冥
# https://leetcode-cn.com/problems/power-of-two/solution/2de-mi-by-leetcode/
# @lc code=start
class Solution(object):
    def isPowerOfTwo(self, n):
        if n == 0:
            return False
        return n & (-n) == n


# class Solution(object):
#     def isPowerOfTwo(self, n):
#         """
#         :type n: int
#         :rtype: bool
#         """
#         if not n:
#             return False
        
#         while n % 2 == 0:
#             n /= 2
#         return n == 1
        
        
# class Solution(object):
#     def isPowerOfTwo(self, n):
#         """
#         :type n: int
#         :rtype: bool
#         """
#         if not n:
#             return False
#         cnt = 0
#         while n > 0:
#             n = n & (n-1)
#             cnt += 1
        
#         return cnt == 1
        
# @lc code=end
if __name__ == "__main__":
    obj = Solution()
    ret = obj.isPowerOfTwo(32)
    print(ret)

