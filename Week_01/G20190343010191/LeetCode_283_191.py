'''
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

* You must do this in-place without making a copy of the array.
* Minimize the total number of operations.
'''

'''
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。

'''

'''
思路1

暴力法


遇到0元素即刪除此元刪

最後把list末尾填上0

Runtime: 44 ms, faster than 91.28% of Python3 online submissions for Move Zeroes.
Memory Usage: 13.9 MB, less than 100.00% of Python3 online submissions for Move Zeroes.

意外結果還不錯?
'''


class Solution1:
    def moveZeroes(self, nums):
        """
        Do not return anything, modify nums in-place instead.
        """
        nums_len = len(nums)
        j = 0
        for i in range(nums_len):
            if nums[j] == 0:
                del nums[j]
                j = j - 1

            j = j + 1
        for i in range(nums_len - len(nums)):
            nums.append(0)


'''

思路2 開新數組(題目不允許此操作)

將非零元素填入新數組，最後按長度補0


Runtime: 44 ms, faster than 91.28% of Python3 online submissions for Move Zeroes.
Memory Usage: 14 MB, less than 100.00% of Python3 online submissions for Move Zeroes.
'''


class Solution2:
    def moveZeroes(self, nums):
        """
        Do not return anything, modify nums in-place instead.
        """

        temp_list = []
        for item in nums:
            if item != 0:
                temp_list.append(item)

        for i in range(len(nums) - len(temp_list)):
            temp_list.append(0)
        nums[:] = temp_list[:]


'''

思路3，雙指針操作


用i 遍歷整個數組
用j 記錄非零元素的位址
所以遇到0 元素的時候，j 不應該移動。意思就是只有遇上非零元素時，j 才會移動

Runtime: 36 ms, faster than 99.49% of Python3 online submissions for Move Zeroes.
Memory Usage: 14 MB, less than 100.00% of Python3 online submissions for Move Zeroes.

這效果最好 不愧是老師教的
'''


class Solution3:
    def moveZeroes(self, nums):
        """
        Do not return anything, modify nums in-place instead.
        """
        j = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[j] = nums[i]
                if i != j:
                    nums[i] = 0
                j = j + 1


if __name__ == "__main__":
    a = [0, 0, 0, 0, 0, 0, 1]
    s1 = Solution2()
    s1.moveZeroes(a)
    print(a)
