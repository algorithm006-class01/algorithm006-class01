class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        left, right = 0, len(nums)-1
        
        while left<=right:
            mid = (left+right)>>1
            
            if nums[mid]==target:
                return mid
            elif nums[mid] < nums[right]:
                if nums[mid] < target and target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
            else:
                if nums[left] <= target and target < nums[mid]:
                    right = mid -1
                else:
                    left = mid + 1
        return -1