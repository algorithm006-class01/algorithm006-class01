class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums) / 2
        for i in set(nums):
            if nums.count(i) > n:
                return i


nums = [2, 2, 1, 1, 1, 2, 2]
aa = Solution()
print(aa.majorityElement(nums))