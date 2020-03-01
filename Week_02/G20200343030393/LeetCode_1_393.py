class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dir_values = {}
        for k, v in enumerate(nums):
            value = dir_values.get(target - v)
            if value is not None:
                return [k, value]
            dir_values[v] = k