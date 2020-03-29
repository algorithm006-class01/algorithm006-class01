#
# @lc app=leetcode.cn id=36 lang=python
#
# [36] 有效的数独
#

# 解题思路
# 1.回溯和剪枝
#   1.对每个行、列，宫格都设置为一个集合Or数组
#   2.循环每个行列，判断元素是否在行列和宫格里面只有一个
# 
# @lc code=start
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        if not board:
            return False
        
        # 初始化行列和宫格数据
        m = 9
        cols = [[] * 9 for _ in range(9)]
        rows = [[] * 9 for _ in range(9)]
        boxs = [[] * 9 for _ in range(9)]
        
        def index(i, j):
            return  (i//3) * 3 + j // 3

        
        for i in range(m):
            for j in range(m):
                if board[i][j] != '.':
                    num = int(board[i][j])
                    if num not in rows[i] and num not in cols[j] and num not in boxs[index(i,j)]:
                        rows[i].append(num)
                        cols[j].append(num)
                        boxs[index(i,j)].append(num)
                    else:
                        return False
        return True
            
        
        
# @lc code=end
