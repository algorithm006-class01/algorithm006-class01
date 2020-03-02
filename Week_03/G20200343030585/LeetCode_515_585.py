#
# @lc app=leetcode.cn id=515 lang=python
#
# [515] 在每个树行中找最大值
#
# 解题思路
# 1.广度优先遍历
#   1.从root开始，没有其他元素就是输出自己的值
#   2.每一行记录最大值，队列保存需要访问的节点
#   3.队列记录下一层有哪些节点需要访问
#   4.需要使用队列的先进先出，python deque
# 
# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        
        res = []
        queue = []
        queue.append(root)
        
        while queue:
            temp = []          
            t = []
            for node in queue:
                t.append(node.val)

                if node.left:
                    temp.append(node.left)
                if node.right:
                    temp.append(node.right)
            
            res.append(max(t))
            queue = temp
            
        return res

# from collections import deque

# class Solution(object):
#     def largestValues(self, root):
#         """
#         :type root: TreeNode
#         :rtype: List[int]
#         """
#         if not root:
#             return []
        
#         res = []
#         queue = deque()
#         queue.append(root)
#         maxVal = float('-inf')
        
#         while queue:
#             length = len(queue)
            
#             for i in range(length):
#                 node = queue.popleft()
                
#                 maxVal = max(maxVal, node.val)
#                 if node.left:
#                     queue.append(node.left)
#                 if node.right:
#                     queue.append(node.right)
            
#             res.append(maxVal)
#             maxVal = float('-inf') 
            
#         return res
        


# @lc code=end

