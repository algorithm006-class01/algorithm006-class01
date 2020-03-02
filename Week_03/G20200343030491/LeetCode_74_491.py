class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix:
            return False
        tmp = []
        for i in matrix:
            tmp.extend(i)

        left, right = 0, len(tmp)-1

        while left <= right:
            mid = (left + right)>>1
            if tmp[mid] == target:
                return True
            elif tmp[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return False


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])
        
        left, right = 0, m*n-1
        
        while left<=right:
            mid = (left+right)>>1
            val = matrix[mid//n][mid%n]
            
            if val == target: return True
            elif val > target:
                right = mid - 1
            else:
                left = mid + 1
                
        return False