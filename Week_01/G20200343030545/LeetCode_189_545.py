"""
    给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

    示例 1:
        输入: [1,2,3,4,5,6,7] 和 k = 3
        输出: [5,6,7,1,2,3,4]
        解释:
        向右旋转 1 步: [7,1,2,3,4,5,6]
        向右旋转 2 步: [6,7,1,2,3,4,5]
        向右旋转 3 步: [5,6,7,1,2,3,4]

    示例 2:
        输入: [-1,-100,3,99] 和 k = 2
        输出: [3,99,-1,-100]
        解释:
        向右旋转 1 步: [99,-1,-100,3]
        向右旋转 2 步: [3,99,-1,-100]

    说明:
        尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
        要求使用空间复杂度为 O(1) 的 原地 算法。
"""
from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        return self.ring(nums, k)

    @classmethod
    def directly(cls, nums: List[int], k: int) -> None:
        """
            暴力求解法
            外层循环k次，内存循环从头到尾依此交换数据
            时间复杂度是O(n*k)，空间复杂度是O(1)
        """
        for i in range(k):
            value = nums[-1]
            for j in range(len(nums)):
                nums[j], value = value, nums[j]

    @classmethod
    def reverse(cls, nums: List[int], k: int) -> None:
        """
            三次反转
            根据 split_point = k%len(nums) 将数组分成两段。
            第一段： 反转列表下标在这个[0, nums_len - split_point - 1]区间内的值。
            第二段： 反转列表下标在这个[nums_len-split, nums-1]区间内的值。
            第一次反转 反转第一段数据。
            第二次反转 反转第二段数据。
            然后整体再反转一次。

            例如 [1, 2, 3, 4, 5, 6, 7]  k =3
            第一段 列表下标区间在[0,3]，即是nums[0]，nums[1]，nums[2]，nums[3]的值。反转后是[4, 3, 2, 1, 5, 6, 7]
            第二段 列表下标区间在[4,6]，即是nums[4]，nums[5]，nums[6]的值。反转后是[4, 3, 2, 1, 7, 6, 5]
            然后整体反转[5, 6, 7, 1, 2, 3, 4]
            时间复杂度是O(n)，空间复杂度是O(1)。
        """
        nums_len = len(nums)
        split_point = k % nums_len

        def swap(left, right):
            while left < right:
                nums[left], nums[right] = nums[right], nums[left]
                left += 1
                right -= 1

        swap(0, nums_len - split_point - 1)
        swap(nums_len - split_point, nums_len - 1)
        swap(0, nums_len - 1)

    @classmethod
    def ring(cls, nums: List[int], k: int) -> None:
        """
            环状替换
            从0开始循环，当0大于等于数组长度的时候或者移动次数等于整个数组长度的时候终止循环
        """

        # FIXME 看了官方的题解后研究了两个小时，Zzz~
        nums_len = len(nums)
        k = k % nums_len

        move_times = i = 0  # 定义初始的指针位置 以及循环次数
        while i < len(nums):
            new_i = (i + k) % nums_len  # 计算出当前下标的新位置
            v = nums[i]  # 存储当前位置的值

            while True:
                old_v = nums[new_i]  # 存储当前下标的新位置的原始值
                nums[new_i] = v  # 更新新位置的值
                v = old_v
                new_i = (new_i + k) % nums_len  # 计算新位置原始值的插入下标
                move_times += 1  # 移动次数加1
                if new_i == i:  # 当新位置的下标等于外层循环指针的值的时候说明这次更新后，外层循环指针的值要移动了
                    nums[new_i] = v  # 但是移动前要把外层循环下标的值更新
                    move_times += 1
                    break
            i += 1

            if move_times == nums_len:
                break


if __name__ == '__main__':
    params_1 = [1, 2, 3, 4, 5, 6]
    params_2 = [1, 2, 3, 4, 5, 6]
    Solution.reverse(params_1, 21)
    Solution.ring(params_2, 21)

    print(params_1)
    print(params_2)
