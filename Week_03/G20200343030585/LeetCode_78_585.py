#
# @lc app=leetcode.cn id=78 lang=python
#
# [78] 子集
#给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

# 说明：解集不能包含重复的子集。

# 示例:

# 输入: nums = [1,2,3]
# 输出:
# [
#   [3],
#   [1],
#   [2],
#   [1,2,3],
#   [1,3],
#   [2,3],
#   [1,2],
#   []
# ]
# 解题思路
# 1. python库itertools方法combinations可以直接实现
# 2. 迭代 
#   1. 由于res=[[]] 当加上个新元素[[1]],结果为res = [[],[1]]
#   2. 只要能产生后面的[2] [2,3] [1,2] [1,2,3]等依次相加就可以
#   3. 这里设计比较巧妙，由于第一个元素为[[]]，这样第一个输出总为空，就可以直接生成单个元素
#   由于目前已经产生了[1],当产生[2]后就可以加上[1]，生成[2,1]
#   4. 产生[3]后就可以产生[3,1],[3,2],[3,2,1],这里产生是不考虑顺序的，如果题目要有序排列就要再加一层排序操作
# 3. 递归 回溯 （和迭代逻辑类似，就是把内层循环替换为递归）
#   1. 第一个是空数组，逐步添加每个单独的元素，一层循环就可以解决
#   2. 每个单独的元素都是可以添加其他后面的元素，就是在一层循环里面加一层递归循环后面的元素
#   3. 由于是递归就可以在后面的递归层次中依次添加上每层后面的元素，直到所有元素被循环完返回
#   4. 这个时候最后一层结果已经添加上了，返回后再把上面各层剩下的迭代执行完

# 以[1,2,3]为例， 执行顺序如下
# [] 
# [1]  递归调用
# [1,2] 递归调用
# [1,2,3] 循环结束，方法返回
# [1,3] 循环结束，方法返回
# [2] 第一层循环,递归调用
# [2,3] 循环2，循环结束
# [3] 循环结束
# @lc code=start

# class Solution:
#     def subsets(self, nums):
#         res = [[]]
#         for i in nums:
#             for num in res:
#                 res = res + [[i] + num]
#         return res

# class Solution:
#     def subsets(self, nums):
#         res = [[]]
#         for i in nums:
#             res = res + [[i] + num for num in res]
#         return res


# import itertools

# class Solution:
#     def subsets(self, nums):
#         res = []
#         for i in range(len(nums)+1):
#             for tmp in itertools.combinations(nums, i):
#                 res.append(tmp)
#         return res


# 理解是最清晰的，就是每次单层循环之后下探，将指针下移一位
# 就可以循环后面的元素，将每个元素都加上，然后再下探，类似这样的循环，每次逻辑都清晰的把当前层元素都加上
# class Solution(object):
#     def subsets(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: List[List[int]]
#         """
#         if len(nums) == 0:
#             return []
#         length = len(nums)
#         res = []
        
#         def recur(idx, ret):
#             res.append(ret)
            
#             for i in range(idx, length):
#                 recur(i + 1, ret + [nums[i]])
#         recur(0, [])
#         return res
        
# class Solution(object):
#     def subsets(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: List[List[int]]
#         """
#         if len(nums) == 0:
#             return []
#         length = len(nums)
#         res = []
#         sub = []
        
#         def recur(idx, sub):
#             if idx == length:
#                 res.append(sub)
#                 return
                
#             recur(idx + 1, sub)  #不选当前元素下探其他元素
#             recur(idx + 1, sub+[nums[idx]]) # 选择当前元素下探其他元素
                

#         recur(0,  sub)
#         return res

        
# @lc code=end

