# N皇后问题，
class Solution(object):
    def solveNQueens(self,n):
        res = []
        if n == 0: return res

        def dfs(row,col,na,pie,cur_res):
            if row == n:
                res.append(["."*cur + "Q"+"."*(n-cur-1) for cur in cur_res])
                return 
            
            for i in range(n):
                if i not in col and i+row not in pie and i-row not in na:
                    dfs(row+1,col|{i}, na|{i-row},pie|{i+row},cur_res+[i])
        
        dfs(0,set(),set(),set(),[])

        return res