class Solution(object):
    def moveZeroes(self, nums):
        zero = 0
        for i in xrange(len(nums)):
            if nums[i] != 0:
                nums[i], nums[zero] = nums[zero], nums[i]
                zero += 1
