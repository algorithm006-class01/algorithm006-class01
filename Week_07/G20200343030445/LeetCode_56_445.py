#
# @lc app=leetcode.cn id=56 lang=python3
#
# [56] 合并区间
#

# @lc code=start
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if not intervals:
            return []
        output = []
        intervals.sort()
        left = intervals[0][0]
        right = intervals[0][1]
        for i in range(len(intervals)):
            if intervals[i][0] > right:
                if [left, right] not in output:
                    output.append([left, right])
                left = intervals[i][0]
                right = intervals[i][1]               
            if intervals[i][0] <= right and intervals[i][1] > right:
                right = intervals[i][1]
        output.append([left, right])
        return output
# @lc code=end

