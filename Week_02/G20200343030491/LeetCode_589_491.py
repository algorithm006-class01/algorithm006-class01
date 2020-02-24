class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if not root:
            return []
        s = [root]
        res = []
        while s:
            cur = s.pop()
            res.append(cur.val)
            for child in cur.children[::-1]:
                s.append(child)
        return res


class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        res = []
        if not root:
            return []
        def rec(node):
            res.append(node.val)
            for i in node.children:
                rec(i)
        rec(root)
        return res