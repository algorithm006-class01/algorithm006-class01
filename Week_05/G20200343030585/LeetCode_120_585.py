#
# @lc app=leetcode.cn id=120 lang=python
#
# [120] 三角形最小路径和
#
# 解题思路
# 1.动态规划
#   1.将塔型问题转化为从上面向下向右的问题
#   2.重复子问题就是每次求当前值的最小路径，存在3中情况
#   当前结点是最右边结点，只能从上面的路径来  dp[i][j] = dp[i-1][j] + dp[i][j]
#   当前结点是最左边结点，只能从上面的右边结点来， dp[i][j] = dp[i-1][j-1] + dp[i][j]
#   当前结点是中间节点，可以从两个结点过来，取最小值即可，因为取的是最小路径，不论从哪来到这个结点的后面的结果都一样，
#   只有前面的不同，所以只需要最小的结果就行    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j]) + dp[i][j] 
#   3.结果存在最后一行结果中，比大小就可以得到最小
# 这里有一点需要理解就是每行的结点数是不一样的，不能用len(triangle[0])的结果
# 
# @lc code=start

# bottom-up, O(n) space
# class Solution(object):
#     def minimumTotal(self, triangle):
#         if not triangle:
#             return 
#         res = triangle[-1]
#         # 从-2行开始到0行
#         for i in range(len(triangle)-2, -1, -1):
#             # 循环每列结点
#             for j in range(len(triangle[i])):
#                 # 下一行的下一个值和下右边的值的最小值+当前结点的值
#                 res[j] = min(res[j], res[j+1]) + triangle[i][j]
#         return res[0]
    
    
# top-down
class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        m = len(triangle)

        for i in range(1, m):
            for j in range(len(triangle[i])):
                if j == 0:
                    # 向下
                    triangle[i][j] = triangle[i][j] + triangle[i-1][j]  
                elif j == len(triangle[i]) - 1:
                    triangle[i][j] = triangle[i][j] + triangle[i-1][j-1]
                else:
                    # 向右
                    triangle[i][j] = triangle[i][j] + min(triangle[i-1][j-1], triangle[i-1][j])      
                    
        return min(triangle[-1])
                

# @lc code=end

