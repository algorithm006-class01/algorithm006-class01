#
# @lc app=leetcode.cn id=105 lang=python
#
# [105] 从前序与中序遍历序列构造二叉树
#
# 解题思路
# 1 递归
#   1. 前序遍历，反向循环遍历逻辑，根、左、右，同时左要小于根，右要大于根
#   2. 前序遍历的第一个元素就是根，这样把中序遍历的数组分成两个部分
#   一部分是左子树，一部分是右子树
#   3.然后重复遍历左子树，重复遍历右子树

# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        self.preorder = preorder
        self.inorder = inorder
        
        self.pre_idx = 0
        self.idx_map = {val:idx for idx, val in enumerate(inorder)}
        return self.construct(0, len(inorder))


    def construct(self, in_left, in_right):
        # there is no element to contruct subtree
        if in_left == in_right:
            return None # return for node
        
        root_val = self.preorder[self.pre_idx]
        root = TreeNode(root_val)
        
        index = self.idx_map[root_val]
        
        self.pre_idx += 1
        root.left = self.construct(in_left, index)
        root.right = self.construct(index + 1, in_right)
        
        return root
            
            
                
        
        
        
# @lc code=end

