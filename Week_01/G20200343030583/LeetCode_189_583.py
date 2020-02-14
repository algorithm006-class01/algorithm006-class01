#
# @lc app=leetcode id=189 lang=python3
#
# [189] Rotate Array
# 1.  pop the last one, insert into first position which is very slow with O(k*n)
# 2.  cyclic replacement in the list (https://leetcode.com/problems/rotate-array/discuss/269948/4-solutions-in-python-(From-easy-to-hard))
# 3.  use reverse (call 3 times): reverse the whole list, reverse first k elements, reverse the rest elements. (same url)
# 4.  use deque (collection.deque(nums)), but O(n) extra memory (https://leetcode.com/problems/rotate-array/discuss/54564/Python-easy-to-understand-solutions.)
# The last solution is not provided in this code file.
# @lc code=start

# first 
# class Solution:
#     def rotate(self, nums: List[int], k: int) -> None:
#         """
#         Do not return anything, modify nums in-place instead.
#         """
#         for i in range(k):
#             e  = nums.pop()
#             nums.insert(0,e)

# second
# class Solution:
#     def rotate(self, nums: List[int], k: int) -> None:
#         """
#         Do not return anything, modify nums in-place instead.
#         """
###       Note that there would be case that the list just contain one elements but k > 1,
###       i.e. reverse itself twice
#         k = k % len(nums) 
#         start = 0
#         count = 0
#         while count < len(nums)
#             current = start
#             prev = nums[current]

#             while True:
#                 next = (current + k) % len(nums)
#                 temp = nums[next]
#                 nums[next] = prev
#                 prev = temp
#                 current = next
#                 count += 1

#                 if start == current:
#                     break
            
#             start += 1

# third
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
###       Note that there would be case that the list just contain one elements but k > 1,
###       i.e. reverse itself twice
        k = k % len(nums)
        # Note that you need to use self._function
        self.reverse(0, len(nums) - 1, nums)
        self.reverse(0, k - 1, nums)
        self.reverse(k, len(nums) - 1, nums)

    # Note that you need to add self as a param in a class
    def reverse(self, start, end, nums) -> None:
        while start < end:
            nums[start],nums[end] = nums[end], nums[start]
            start += 1
            end -= 1


# @lc code=end

