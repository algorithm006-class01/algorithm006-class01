#
# @lc app=leetcode id=74 lang=python3
#
# [74] Search a 2D Matrix
#
# https://leetcode.com/problems/search-a-2d-matrix/description/
#
# algorithms
# Medium (35.86%)
# Likes:    1341
# Dislikes: 141
# Total Accepted:    287.7K
# Total Submissions: 801.6K
# Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,50]]\n3'
#
# Write an efficient algorithm that searches for a value in an m x n matrix.
# This matrix has the following properties:
# 
# 
# Integers in each row are sorted from left to right.
# The first integer of each row is greater than the last integer of the
# previous row.
# 
# 
# Example 1:
# 
# 
# Input:
# matrix = [
# ⁠ [1,   3,  5,  7],
# ⁠ [10, 11, 16, 20],
# ⁠ [23, 30, 34, 50]
# ]
# target = 3
# Output: true
# 
# 
# Example 2:
# 
# 
# Input:
# matrix = [
# ⁠ [1,   3,  5,  7],
# ⁠ [10, 11, 16, 20],
# ⁠ [23, 30, 34, 50]
# ]
# target = 13
# Output: false
# 
#

# @lc code=start
# 自己想的 两次二分法 感觉逻辑很冗余
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
        start_x, end_x = 0, len(matrix) - 1
        start_y, end_y = 0, len(matrix[0]) - 1
        row = 0

        while start_x + 1 < end_x:
            mid = start_x + (end_x - start_x) // 2
            if matrix[mid][0] == target:
                return True
            elif matrix[mid][0] > target:
                end_x = mid
            else:
                start_x = mid
        if matrix[start_x][0] == target:
            return True
        if matrix[end_x][0] == target:
            return True
        
        if matrix[end_x][0] < target:
            row = end_x
        else:
            row = start_x

        while start_y + 1 < end_y:
            mid = start_y + (end_y - start_y) // 2
            if matrix[row][mid] == target:
                return True
            elif matrix[row][mid] > target:
                end_y = mid
            else:
                start_y = mid
        if matrix[row][start_y] == target:
            return True
        if matrix[row][end_y] == target:
            return True
        return False

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
        
        row, col = len(matrix), len(matrix[0])
        start, end = 0, col * row - 1 

        while start + 1 < end:
            mid = start + (end - start) // 2
            x, y = mid // col, mid % col
            if matrix[x][y] < target:
                start = mid
            else:
                end = mid
        x, y = start // col, start % col
        if matrix[x][y] == target:
            return True

        x, y = end // col, end % col
        if matrix[x][y] == target:
            return True

        return False

# @lc code=end

