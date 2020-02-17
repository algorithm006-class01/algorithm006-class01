#
# @lc app=leetcode.cn id=283 lang=python3
#
# [283] 移动零
#

# @lc code=start
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        n = len(nums)
        if (n <= 1):
            return nums

        # # bubble sort version
        # for i in range(n):
        #     # 提前退出冒泡循环的标志位
        #     flag = False
        #     for j in range(n-i-1):
        #         if (nums[j] == 0 and nums[j+1] != 0):
        #             nums[j], nums[j+1] = nums[j+1], nums[j]
        #             flag = True
        #     if not flag:
        #         break
        
        # insertion sort version
        for i in range(1, n):
            value = nums[i]
            j = i - 1
            while j >= 0 and nums[j] == 0 and value != 0:
                nums[j+1] = nums[j]
                j -= 1
            nums[j+1] = value

        return nums
        
# @lc code=end

