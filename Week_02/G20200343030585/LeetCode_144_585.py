# 解题思路：
# 前序遍历就是先访问根节点，再遍历左子树，然后是遍历右子树
# 可以通过一个递归完成遍历过程

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        
        if root is None:
            return []
        
        res = []
        self._preorderTraversal(root, res)
        return res
    
    def _preorderTraversal(self, node, res = []):
        res.append(node.val)
        if node.left is not None:
            self._preorderTraversal(node.left, res)
        if node.right is not None:
            self._preorderTraversal(node.right, res)
        
    