#
# @lc app=leetcode.cn id=191 lang=python
#
# [191] 位1的个数
#

# @lc code=start
class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0:
            return n
        count = 0
        while n > 0:
            # 如果低位是1则相与后只有一位变化
            # 如果低位是0则相与后会一直变化到最后一个1停止，
            # 后面如果还有1就继续变化，再相与，知道所有1都变为0
            n &= (n - 1)
            count += 1
        
        return count
# @lc code=end

