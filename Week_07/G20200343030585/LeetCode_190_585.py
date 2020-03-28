#-*- coding:utf-8 -*-
# @lc app=leetcode.cn id=190 lang=python
#
# [190] 颠倒二进制位
#
# 解题思路
# 1.移位
#   1 用1与n的低位与，得到低位

# @lc code=start
class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        if n == 0:
            return n
        
        ans = 0
        for _ in range(31, -1, -1):
            ans <<= 1
            ans += n & 1
            n >>= 1
        
        return ans
        
        
# @lc code=end

if __name__ == "__main__":
    obj = Solution()
    ret = obj.reverseBits(43261596)
    print(bin(ret))