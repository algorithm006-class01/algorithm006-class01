class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        if not root:
            return []
        res.append(root.val)
        res += self.preorderTraversal(root.left)
        res += self.preorderTraversal(root.right)
        
        return res

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        if not root:
            return []
        s = [root]
        while s:
            cur = s.pop()
            if cur:
                res.append(cur.val)
                s.append(cur.right)
                s.append(cur.left)
        return res