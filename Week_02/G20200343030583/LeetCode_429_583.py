#
# @lc app=leetcode id=429 lang=python
#
# [429] N-ary Tree Level Order Traversal
#

# @lc code=start
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
# recursively
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        if root is None:
            return []
        
        def leveldown(root,level):
            if root is None:
                return
            
            if len(result) == level:
                result.append([])
            result[level].append(root.val)
            for c in root.children:
                leveldown(c, level + 1)
                
        result = []
        leveldown(root, 0)
        return result

# Use BFS with queue
import collections
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        if root is None:
            return []
        
        result = []
        queue = collections.deque([root])
        while queue:
            level = []
            for _ in range(len(queue)):
                node = queue.popleft()
                level.append(node.val)
                queue.extend(node.children)
            result.append(level)
        
        return result

# simplified BFS
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        if root is None:
            return []
        
        result = []
        previous_level = [root]
        while previous_level:
            result.append([])
            current_level = []
            for node in previous_level:
                result[-1].append(node.val)
                current_level.extend(node.children)
            previous_level = current_level

        return result
# @lc code=end

