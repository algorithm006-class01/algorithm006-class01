class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        last = now = 0
        for i in nums:
            last, now = now, max(last + i, now)
        return now


nums = [1, 2, 3, 1]
aa = Solution()
print(aa.rob(nums))