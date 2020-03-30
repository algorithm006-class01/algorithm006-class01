#
# @lc app=leetcode.cn id=190 lang=python3
#
# [190] 颠倒二进制位
#

# @lc code=start
class Solution:
    def reverseBits(self, n: int) -> int:
        ans, mask = 0, 1
        for i in range(32):
            if n & mask:
                ans |= 1 << (31 - i)
            # bit LOOP:: 从最右边开始一个个看
            mask <<= 1

        return ans
        
# @lc code=end

