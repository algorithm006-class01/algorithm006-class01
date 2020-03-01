class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def rec(node):

            if (not node.left) and (not node.right):
                return [[node]]
            if not node.left:
                return [[node]+i for i in rec(node.right)]+[[node]]
            if not node.right:
                return [[node]+i for i in rec(node.left)]+[[node]]
            return [[node]+i for i in rec(node.left) + rec(node.right)]+[[node]]
            
        path =  rec(root)
        temp = []
        for i in path:
            if i[-1] == q or i[-1] == p:
                temp.append(i)
                
        return [i for i in temp[0] if i in temp[1]][-1]


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None
        if q is root or p is root:
            return root
        
        left = self.lowestCommonAncestor(root.left,p,q)
        right = self.lowestCommonAncestor(root.right,p,q)
        
        if left and not right:
            return left
        if right and not left:
            return right
        if left and right:
            return root

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if root in [None, p, q]: return root
        
        left, right = (self.lowestCommonAncestor(i,p,q) for i in [root.left, root.right])
        
        return root if right and left else right or left
