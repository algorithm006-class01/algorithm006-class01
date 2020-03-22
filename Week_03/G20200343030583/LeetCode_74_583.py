#
# @lc app=leetcode id=74 lang=python
#
# [74] Search a 2D Matrix
# 1. check the first element of each row frist then check exact row 
# 2. flatten matrix

# @lc code=start
# 1.
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        left = 0
        right = len(matrix) - 1
        hit = False
        if not matrix:
            return False
        while left <= right:
            mid = left + (right - left)/2
            # [[]] case
            if not matrix[mid]:
                return False
            if matrix[mid][0] == target:
                return True
            if matrix[mid][0] < target:
                if mid + 1 < len(matrix) and target >=matrix[mid + 1][0]:
                    left = mid + 1
                else:
                    hit = True
                    # matrix[mid] may contain targets
                    break
            elif matrix[mid][0] > target:
                if mid - 1 >= 0 and matrix[mid - 1][0] > target:
                    right = mid - 1
                else:
                    mid = mid - 1
                    hit = True
                    break
        if hit:
            left = 0
            right = len(matrix[mid]) - 1
            while left <= right:
                mid_mid = left + (right - left)/2
                if matrix[mid][mid_mid] == target:
                    return True
                if matrix[mid][mid_mid] > target:
                    right = mid_mid - 1
                else:
                    left = mid_mid + 1
        return False

# 2. flatten matrix
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """ 
        if not matrix or not matrix[0]:
            return False
        row = len(matrix) 
        col = len(matrix[0]) 
        left, right = 0,  row * col - 1
        while left <= right:
            mid = left + (right - left)/2
            num = matrix[mid/col][mid%col]
            if  num == target:
                return True
            elif num < target:
                left = mid + 1
            else:
                right = mid - 1

        return False
# @lc code=end

