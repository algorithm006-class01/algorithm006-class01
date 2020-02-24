class Solution(object):
    def preorder(self, root, res=None):
        """
        :type root: Node
        :rtype: List[int]
        """
        # if not root: return []
        # if not res: res = []
        #
        # for i in root.children: res += self.preorder(i)
        # return [root.val] + res

        if not root: return []
        res = []

        def dfs(root):
            if not root:
                return
            res.append(root.val)
            for i in root.children:
                dfs(i)

        dfs(root)
        return res