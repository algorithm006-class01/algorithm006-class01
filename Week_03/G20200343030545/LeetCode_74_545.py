"""
    编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
        每行中的整数从左到右按升序排列。
        每行的第一个整数大于前一行的最后一个整数。

    示例 1:
        输入:
            matrix = [
              [1,   3,  5,  7],
              [10, 11, 16, 20],
              [23, 30, 34, 50]
            ]

            target = 3
        输出: true

    示例 2:

        输入:
            matrix = [
              [1,   3,  5,  7],
              [10, 11, 16, 20],
              [23, 30, 34, 50]
            ]
            target = 13
        输出:
            false
"""

from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        return self.mid_query(matrix, target)

    @classmethod
    def convert(cls, matrix: List[List[int]], target: int) -> bool:
        """
        时间复杂度 O(m+logm*n)  k为二位数组中 的行数
        空间复杂度 O(m*n)         n为二维数组中总个数
        """
        new_nums = []
        for nums in matrix:
            new_nums.extend(nums)

        start = 0
        end = len(new_nums) - 1

        while start <= end:
            mid = (start + end) // 2
            if new_nums[mid] == target:
                return True
            if new_nums[mid] > target:
                end = mid - 1
            else:
                start = start + 1
        return False

    @classmethod
    def mid_query(cls, matrix: List[List[int]], target: int) -> bool:
        """
            将二维数组视为一维数组 套用二分查找的模版
            时间复杂度: O(log mn)
            空间复杂度: O(1)
        """
        if matrix and matrix[0]:
            row = len(matrix)
            col = len(matrix[0])

            start = 0
            end = row * col - 1

            while end >= start:
                mid = (start + end) // 2
                mid_val = matrix[mid // col][mid % col]
                if mid_val == target:
                    return True
                elif mid_val > target:
                    end = mid - 1
                else:
                    start = mid + 1
        return False


if __name__ == '__main__':
    Solution.mid_query(
        [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]], 3)
