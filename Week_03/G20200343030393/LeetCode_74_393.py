class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        combination = []
        for i in matrix:
            combination += i

        left, right = 0, len(combination) - 1
        while left <= right:
            mid = (left + right) // 2
            if combination[mid] == target:
                return True
            elif combination[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return False


matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
aa = Solution()
print(aa.searchMatrix(matrix, target))