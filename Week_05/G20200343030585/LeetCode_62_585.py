#
# @lc app=leetcode.cn id=62 lang=python
#
# [62] 不同路径
#
# 解题思路
# 1.动态规划
#   1.重复子问题，每一次的path都来之上一阶段的路径结果
#   2.无后效性，就是后面不会改变前面的结果
#   3.最优子结构，这里不需要最优，需要所有解
# 2.动态规划
#   1、我们令 dp[i][j] 是到达 i, j 最多路径
#   2、动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
#   3、注意，对于第一行 dp[0][j]，或者第一列 dp[i][0]，由于都是在边界，所以只能为 1
#   每次从上面两种走法里面取和，下一步的走法等于上面走法 + 1，类似faboaral数列
# 思路二 
# 优化一：
#   由于dp[i][j] = dp[i-1][j] + dp[i][j-1]，
#   因此只需要保留当前行与上一行的数据 
#   (在动态方程中，即pre[j] = dp[i-1][j])，两行，空间复杂度O(2n)； 
# 优化二：
#   cur[j] += cur[j-1], 即cur[j] = cur[j] + cur[j-1] 
#   等价于思路二-->> cur[j] = pre[j] + cur[j-1]，
#   因此空间复杂度为O(n).

# @lc code=start
class Solution(object):
    def uniquePaths(self, m, n):
        """
        cur为上一行的数据，然后直接在下一行里面使用，然后赋值
        """
        cur = [1] * n
        for i in range(1, m):
            for j in range(1, n):
                cur[j] += cur[j-1]
        return cur[-1]

# class Solution(object):
#     def uniquePaths(self, m, n):
#         """
#         计算每步的值，只需要当前节点前一个和上一个节点，等于只需要两行数据
#         pre为上一行数据，cur为当前行数据
#         """
#         pre = [1] * n
#         cur = [1] * n
#         for i in range(1, m):
#             for j in range(1, n):
#                 cur[j] = pre[j] + cur[j-1]
#             pre = cur[:]
#         return pre[-1]

# class Solution(object):
#     def uniquePaths(self, m, n):
#         """
#         :type m: int
#         :type n: int
#         :rtype: int
#         """
#         # [1] * n 第一行，[1] + [0] * （n-1）构建matrix值，
#         # 第一行和第一列的值为1
#         # m是行  n是列
#         dp = [[1]*n] + [[1]+[0] * (n-1) for _ in range(m-1)]
#         # print(dp)
        
#         for i in range(1, m):
#             for j in range(1, n):
#                 dp[i][j] = dp[i-1][j] + dp[i][j-1]
                
#         return dp[-1][-1]
        
        
        

# 超时
# class Solution(object):
#     def uniquePaths(self, m, n):
#         """
#         :type m: int
#         :type n: int
#         :rtype: int
#         """
#         if m == 0 or n == 0:
#             return 0
#         def dp(down, right, path, res):
#             if down == n - 1 and right == m - 1:
#                 res.append(path)
#                 return
            
#             if down + 1 < n:
#                 dp(down + 1, right, path + [(down + 1, right)], res)
                
#             if right + 1 < m:
#                 dp(down, right + 1, path + [(down, right + 1)], res)
                
#         res = []
#         dp(0, 0, [(0,0)], res)

#         return len(res)
            
        
# @lc code=end

