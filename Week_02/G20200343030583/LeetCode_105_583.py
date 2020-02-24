#
# @lc app=leetcode id=105 lang=python
#
# [105] Construct Binary Tree from Preorder and Inorder Traversal
# node in preorder will split nodes in inorder into left subtree and right subtree


# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        # index in preorder
        self.preidx = 0
    
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        def build(in_left = 0, in_right = len(inorder)):
            if in_left == in_right:
                return None
            
            root_val = preorder[self.preidx]
            root = TreeNode(root_val)

            self.preidx += 1
            index = idx_map[root_val]

            root.left = build(in_left, index)
            root.right = build(index + 1, in_right)
            return root
        
        # consturct a map from val to index on inorder list
        idx_map = {val:idx for idx,val in enumerate(inorder)}

        return build()
# @lc code=end

