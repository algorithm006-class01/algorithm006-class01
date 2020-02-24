#
# @lc app=leetcode.cn id=226 lang=python
#
# [226] 翻转二叉树
# 题目理解
# 1. 对二叉树翻转的认知首先是左子树和右子树交换位置
# 2。对每个子树下的左右元素交换位置
# 解题思路
# 1.使用递归来解题，不断交换当前元素的左节点和右节点
#    1。首先翻转根的左和右子树
#    2. 递归左子树和右子树，实现两者的孩子进行交换
#    3. 递归结束条件，如果孩子为空就结束了
#    4. 如何没有根没有孩子也结束了
# 时间复杂度 O(N)
# 空间复杂度 O(N), 因为使用递归调用，总共需要2^h - 2h - 1次递归
# h为二叉树高度，2^h - 1 接近n，所有整体为O(N)

# 2.使用循环来解题
#   1。每次把子节点交换一遍，然后将左右节点添加入栈
#   2. 循环栈的元素，知道没有元素为止
# 时间复杂度O(N) 需要把每个元素都遍历一遍
# 空间复杂度O(N) 最坏的情况有N/2的节点在stack里面

# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        st = []
        if root is None:
            return None
        
        st.append(root)
        
        while len(st) != 0:
            node = st.pop()
            
            temp = node.left
            node.left = node.right
            node.right = temp
            
            if node.left: st.append(node.left)
            if node.right: st.append(node.right)
        
        return root
            

# class Solution(object):
#     def invertTree(self, root):
#         """
#         :type root: TreeNode
#         :rtype: TreeNode
#         """
#         if root is None:
#             return None
#         left = root.left
#         right = root.right
#         if left:    
#             self.invertTree(left)
#         if right:
#             self.invertTree(right)

#         root.left = right
#         root.right = left    

#         return root

# @lc code=end

