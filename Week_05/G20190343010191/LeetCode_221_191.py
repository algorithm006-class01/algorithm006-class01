"""
221. Maximal Square
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4


"""

class Solution(object):
    def maximalSquare(self, matrix):
        if (not matrix) or (not matrix[0]):
            return 0
        n = len(matrix)
        m = len(matrix[0])
        widths = [0] * n
        k = 0
        for j in range(0, m):
            max_continous_k = 0
            continous_k = 0
            for i in range(0, n):
                if matrix[i][j] == '1':
                    widths[i] += 1
                else:
                    widths[i] = 0
                if widths[i] > k:
                    continous_k += 1
                    max_continous_k = max(continous_k, max_continous_k)
                else:
                    continous_k = 0
            if max_continous_k > k:
                k += 1
        return k * k