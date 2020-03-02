#
# @lc app=leetcode.cn id=102 lang=python
#
# [102] 二叉树的层次遍历
# 
# 解题思路
# 1.就是广度优先遍历所有二叉树节点
#   1.定义一个队列来记录所有需要遍历的二叉树节点
#   2.首先添加根节点
#   3.循环弹出根节点，记录其所有子节点
#   4.直到所有节点都输出，返回
# 复杂度分析
# 时间复杂度：O(N)，因为每个节点恰好会被运算一次。
# 空间复杂度：O(N)，保存输出结果的数组包含 N 个节点的值。
# 
# 2. 迭代实现
#   1.主要解决一个是level的问题，要确定是哪个层的元素，就要保证每次出来的元素都是这一层的元素
#   2.要确定每次循环的层的大小，这样就可以限制每次只循环这些元素，再通过循环把下一层的元素都加进来
#   3.比如这一层有2个元素，同时下一层有4个元素，在循环的时候，这一层的元素个数已经确定了，所以只有2次循环，
#   下一层按照先进先出的顺序，从右进从左出，这样就能保证出栈顺序不错，每次输出不错
# 复杂度分析

# 时间复杂度：O(N)，因为每个节点恰好会被运算一次。
# 空间复杂度：O(N)，保存输出结果的数组包含 N 个节点的值。

# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque 

class Solution:
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        levels = []
        if not root:
            return levels
        
        level = 0
        queue = deque([root,])
        while queue:
            # start the current level
            levels.append([])
            # number of elements in the current level 
            level_length = len(queue)
            
            for i in range(level_length):
                node = queue.popleft()
                # fulfill the current level
                levels[level].append(node.val)
                
                # add child nodes of the current level
                # in the queue for the next level
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            
            # go to next level
            level += 1
        
        return levels


# class Solution(object):
#     def levelOrder(self, root):
#         """
#         :type root: TreeNode
#         :rtype: List[List[int]]
#         """
#         res = [[]]
#         if root is None:
#             return []
                
#         def bfs(node, level):
#             if len(res) == level:
#                 res.append([])
                
#             res[level].append(node.val)
            
#             if node.left:
#                 bfs(node.left, level+1)
#             if node.right:
#                 bfs(node.right, level+1)

#         bfs(root, 0)
#         return res            
                    
        
        
        
# @lc code=end

