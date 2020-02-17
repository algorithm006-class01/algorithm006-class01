"""
    给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
    使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

    注意：答案中不可以包含重复的三元组。

    示例：
        给定数组 nums = [-1, 0, 1, 2, -1, -4]，
        满足要求的三元组集合为：
        [
          [-1, 0, 1],
          [-1, -1, 2]
        ]
"""

from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        return self.three_pointer_loop(nums)

    @classmethod
    def three_pointer_loop(cls, nums: List[int]) -> List[List[int]]:
        """
            先将列表进行排序，用python自带的sort就行。
            用三个指针处理。两层循环，外层循环的遍历列表，内层循环是对第二个和第三个指针进行移位比较操作。

            第一个指针从头开始遍历列表。
            第二个指针每次的初始位置都是第一个指针的下标+1
            第三个指针每次的初始位置都是列表的最后一个元素。
            跳出循环的条件是：
                1、循环遍历完成
                2、有下标对应的值大于0。
            时间复杂度是O(n^2)，空间复杂度是O(1)
        """

        res = []

        nums.sort()

        for index in range(len(nums)):
            start_index = index + 1
            end_index = len(nums) - 1

            if nums[index] > 0:
                return res

            if index > 0 and nums[index] == nums[index - 1]:
                continue

            while end_index > start_index:
                check_sum = nums[index] + nums[start_index] + nums[end_index]

                if check_sum == 0:
                    res.append([nums[index], nums[start_index], nums[end_index]])

                    while end_index > start_index and nums[start_index] == nums[start_index + 1]:
                        start_index += 1

                    while end_index > start_index and nums[end_index] == nums[end_index - 1]:
                        end_index -= 1

                    start_index += 1
                    end_index -= 1
                elif nums[end_index] > check_sum:
                    end_index -= 1
                else:
                    start_index += 1
        return res


if __name__ == '__main__':
    print(Solution.directly([-1, 0, 1, 2, -1, -4]))
