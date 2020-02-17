class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k %= n
        temp = (nums + nums)[n-k:2*n-k]
        for i in range(n):
            nums[i] = temp[i]