"""
    给出一个区间的集合，请合并所有重叠的区间。
    示例 1:
        输入: [[1,3],[2,6],[8,10],[15,18]]
        输出: [[1,6],[8,10],[15,18]]
        解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    示例 2:
        输入: [[1,4],[4,5]]
        输出: [[1,5]]
        解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
"""
from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        res = []
        for start, end in intervals:
            if not res:
                res.append([start, end])
            else:
                check_start, check_end = res[-1]
                if check_start <= start <= check_end:
                    res[-1] = [min(check_start, start), max(check_end, end)]
                else:
                    res.append([check_start, check_end])

        return res
