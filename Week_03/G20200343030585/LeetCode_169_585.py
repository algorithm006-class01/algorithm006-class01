#
# @lc app=leetcode.cn id=169 lang=python
#
# [169] 多数元素
#
#
# 解题思路
# 1.暴力法
#   时间复杂度O(n)
# 2.哈希表
#   依次循环计算所有元素的出现次数，如果次数大于 n/2就是
#   时间复杂度O(n)
# 3.排序法
#   由于众数元素的次数是大于一半元素的，所有排序后中间的元素肯定是它
#   时间复杂度O(nlgn),python 和java排序是nlogn的时间复杂度
# 4.递归 分治
#   1. 子问题是划分左右两边，找其中的多数元素，如果左右相同取其一，左右不同就再计算两边的多数都出现了多数次比大小
# 时间复杂度O(nlogn) 通过主定理推导
# 空间复杂度O(lgn) 通过递归最长路径获得logn,就是二叉树的高度


# @lc code=start
# class Solution:
#     def majorityElement(self, nums):
#         majority_count = len(nums)//2
#         for num in nums:
#             # 语法糖太有趣 
#             # 1是实际输出的内容，后面是迭代器，确定1输出多少次
#             # (1 for elem in nums if elem == num)
#             count = sum(1 for elem in nums if elem == num)
#             if count > majority_count:
#                 return num
        
# class Solution:
#     def majorityElement(self, nums):
#         half = len(nums)/2
#         #使用counter计算出每个元素的出现次数
#         counts = collections.Counter(nums)
#         # 默认出现次数最大的输出，但是如果最大的不满足1半呢？
#         for k,v in counts.items():
#             if v > half:
#                 return k
#         # 特别简洁的写法，直接高地迭代取最大值
#         # return max(counts.keys(), key=counts.get)

# class Solution:
#     def majorityElement(self, nums):
#         nums.sort()
#         return nums[len(nums)/2]


class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        if length == 0:
            return 0

        def recur(start, end):
            # check terminator 
            # 因为要用end的值来返回，所以end不能是length
            if start == end:
               return nums[start]
                
            #  current level logic
            idx = (end - start) // 2  + start     
            #  drill down
            left = recur(start, idx)
            right = recur(idx + 1, end)
            
            if left == right:
                return left
            
            # 计算左右两边谁的多数元素多,这里有个问题要注意，就是比较两边的值，range是不包含end的结果循环的
            # 所以只用end会导致少一个循环比较
            left_compare = sum(1 for i in range(start, idx + 1) if nums[i] == left)
            right_compare = sum(1 for j in range(idx + 1, end + 1) if nums[j] == right)

            return left if left_compare > right_compare else right
            
            # recover state
            
        return recur(0, length - 1)

# @lc code=end

