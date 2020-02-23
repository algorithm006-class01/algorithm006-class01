class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        if not root:
            return []
        s=[root]
        l = []
        while s:
            cur = s.pop()
            if cur:
                l.append(cur.val)
            s.extend(cur.children)
        return l[::-1]


class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        res = []
        if not root: return []
        def rec(node):
            for child in node.children:
                rec(child)
            res.append(node.val)
        rec(root)
        return res