"""
    给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
    你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
    返回滑动窗口中的最大值。

    示例:
        输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
        输出: [3,3,5,5,6,7]

    解释:
      滑动窗口的位置                最大值
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7

    提示：
        你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
"""
from typing import List


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        return self.directly(nums, k)

    @classmethod
    def directly(cls, nums: List[int], k: int) -> List[int]:
        """
            暴力求解法
            外层循环控制列表元素的遍历
            内层循环控制 k个数的循环
            时间复杂度O(n*k)，空间复杂度O(n-k+1)
        """
        res = []
        for i in range(len(nums)):
            max_value = float("-inf")
            for j in range(i, k + i):
                max_value = max(nums[j], max_value)
            res.append(max_value)
            if i == len(nums) - k:
                break
        return res


if __name__ == '__main__':
    params = [1, 3, -1, -3, 5, 3, 6, 7]
    num = 3

    print(Solution.directly(params, num))
