class Solution:
    def jump(self, nums: List[int]) -> int:
        end, maxPos, step = 0, 0, 0
        
        for i in range(len(nums)-1):
            maxPos = max(maxPos, i+nums[i])
            if i == end:
                end = maxPos
                step += 1
            
        return step

class Solution:
    def jump(self, nums: List[int]) -> int:
        step = 0
        pos = len(nums)-1
        while pos>0:
            for i in range(len(nums)):
                if nums[i] + i >= pos:
                    pos = i
                    step += 1
                    break
        
        return step
                