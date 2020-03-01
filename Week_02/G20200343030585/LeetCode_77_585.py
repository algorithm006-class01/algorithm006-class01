#
# @lc app=leetcode.cn id=77 lang=python
#
# [77] 组合
#
# 解题思路(直接用的leetcode官方解答)
# 1. 回溯法 
#   1. 通过遍历所有可能成员来寻找全部可行解的算法
#   2. 将要添加到组合和现有组合作为参数
#   3. 若已达到需要的大小就添加返回
#   4. 遍历从 first 到 n 的所有整数。
#   5. 继续向组合中添加更多参数
#   6. 将添加的i移除，实现回溯
# 复杂度分析
# 时间复杂度 : O(k C_N^k)，其中 C_N^k = N!/(N−k)!k! 是要构成的组合数。
# append / pop (add / removeLast) 操作使用常数时间，唯一耗费时间的是将长度为 k 的组合添加到输出中。
# 空间复杂度 : O(C_N^k)，用于保存全部组合数以输出。

# @lc code=start
class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        def backtrack(first = 1, curr = []):
            # if the combination is done
            if len(curr) == k:  
                output.append(curr[:])
            for i in range(first, n + 1):
                # add i into the current combination
                curr.append(i)
                # use next integers to complete the combination
                backtrack(i + 1, curr)
                # backtrack
                curr.pop()
        
        output = []
        backtrack()
        return output

        
# @lc code=end

