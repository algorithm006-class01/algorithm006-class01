"""
Python果然简洁了很多，自带字典就是好
"""
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        d = dict();
        for idx, val in enumerate(nums):
            if (target - val ) in d:
                return [idx, d[target - val]]
            else:
                d[ val ] = idx;
