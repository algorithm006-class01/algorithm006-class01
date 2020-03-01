#
# @lc app=leetcode.cn id=189 lang=python3
#
#

# @lc code=start
class Solution:
    def preorderTraversal(self, root):
        """
        Do not return anything, modify nums in-place instead.
        """
        """
        Do not return anything, modify nums in-place instead.
        """
        
    ret = []
    stack = [root]
    while stack:
        node = stack.pop()
        if node:
            ret.append(node.val)
            stack.append(node.right)
            stack.append(node.left)
    return ret
# @lc code=end

