class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = dict()
        for index, num in enumerate(nums):
            if d.get(num) == None:
                d[target - num] = index
            else:
                return [d.get(num), index]