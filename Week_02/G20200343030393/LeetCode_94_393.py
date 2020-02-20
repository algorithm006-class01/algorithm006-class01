class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        def dfs(root):
            if not root:
                return
            dfs(root.right)
            res.append(root.val)
            dfs(root.left)
        dfs(root)
        return res