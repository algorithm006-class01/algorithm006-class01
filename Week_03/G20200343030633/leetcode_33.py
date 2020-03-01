class Solution:
    def search(self, nums, target):
        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right) // 2
            if nums[0] <= nums[mid] and (target > nums[mid] or target < nums[0]):
                left = mid + 1
            elif nums[mid] < target < nums[0]:
                left = mid + 1
            else:
                right = mid
        if left == right and nums[left] == target:
            return left
        else:
            return -1


array = [4, 5, 6, 7, 0, 1, 2, 3]
solution = Solution()
print(solution.search(array, 0))

