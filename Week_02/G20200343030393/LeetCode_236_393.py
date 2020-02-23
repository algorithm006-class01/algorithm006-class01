class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if root in (None, p, q):
            return root
        left = self.lowestCommonAncestor(root.left, p, q)

        if left not in (None, p, q):
            return left
        right = self.lowestCommonAncestor(root.right, p, q)

        if left and right:
            return root
        else:
            return left or right

        # if root in (None, p, q):
        #     return root
        #
        # left, right = (self.lowestCommonAncestor(kid, p, q) for kid in (root.left, root.right))
        # if left and right:
        #     return root
        # else:
        #     return left or right