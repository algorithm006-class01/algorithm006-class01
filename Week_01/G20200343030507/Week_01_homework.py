#https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums:
            return 0
        k = 1
        for i in range(1, len(nums)):
            if nums[i] != nums[i - 1]:
                nums[k] = nums[i]
                k += 1
        return k

#https://leetcode-cn.com/problems/rotate-array/
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k %= n
        nums[:] = nums[::-1]
        nums[:k] = nums[:k][::-1]
        nums[k:] = nums[k:][::-1]

#https://leetcode-cn.com/problems/merge-two-sorted-lists/
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1 or not l2:
            return l1 or l2
        if l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2

#https://leetcode-cn.com/problems/merge-sorted-array/
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        p1 = m - 1
        p2 = n - 1 
        p = m + n - 1
        while p1 > 0 and p2 > 0:
            if nums1[p1] < nums2[p2]:
                nums1[p] = nums2[p2]
                p2 -= 1
            else:
                nums1[p] = nums1[p1]
                p1 -= 1
            p -= 1
        
        nums1[:p2 + 1] = nums2[:p2 + 1]

#https://leetcode-cn.com/problems/two-sum/
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = dict()
        for index, num in enumerate(nums):
            if d.get(num) == None:
                d[target - num] = index
            else:
                return [d.get(num), index]

#https://leetcode-cn.com/problems/move-zeroes/
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        count = nums.count(0)
        nums[:] = [i for i in nums if i != 0]
        nums += [0]*count
        return nums

#https://leetcode-cn.com/problems/plus-one/
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        num = 0
        for i in range(len(digits)):
            num += digits[i] * pow(10, (len(digits) - i - 1))
        return [int(i) for i in str(num + 1)]
