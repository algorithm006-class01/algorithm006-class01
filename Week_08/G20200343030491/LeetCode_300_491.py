class Solution:
    def findIdx(self, tail,target):
        left, right = 0, len(tail)-1
        while left<right:
            mid = (left+right)//2
            if target<=tail[mid]:
                right = mid
            else:
                left = mid+1
        return left
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        tail = [nums[0]]
        for i in range(1,len(nums)):
            if nums[i]<=tail[-1]:
                idx = self.findIdx(tail,nums[i])
                tail[idx] = nums[i]
            else:
                tail.append(nums[i])
                
        return len(tail)

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        dp = [1] * (len(nums))
        for i in range(1,len(nums)):
            for j in range(i):
                if nums[j]<nums[i] and dp[j]>dp[i]-1:
                    dp[i] = dp[j]+1
        return max(dp)