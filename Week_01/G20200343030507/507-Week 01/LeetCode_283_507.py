class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        count = nums.count(0)
        nums[:] = [i for i in nums if i != 0]
        nums += [0]*count
        return nums