class Solution:
    def canJump(self, nums: List[int]) -> bool:
        k = 0
        for i in range(len(nums)):
            if i > k: return False
            k = max(k, i+nums[i])
        
        return True

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        lastPos = len(nums)-1
        for i in range(lastPos,-1,-1):
            if (i+nums[i])>=lastPos:
                lastPos = i
                
        return True if lastPos == 0 else False