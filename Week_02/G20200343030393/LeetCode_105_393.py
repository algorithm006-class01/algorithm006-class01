class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if inorder:
            inx = inorder.index(preorder.pop(0))
            root = TreeNode(inorder[inx])
            root.left = self.buildTree(preorder, inorder[0: inx])
            root.right = self.buildTree(preorder, inorder[inx + 1:])
            return root