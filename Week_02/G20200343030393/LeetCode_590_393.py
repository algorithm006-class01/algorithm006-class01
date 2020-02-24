class Solution(object):
    def postorder(self, root, res=None):
        """
        :type root: Node
        :rtype: List[int]
        """
        if not root: return []
        if not res: res = []
        for i in root.children: res += self.postorder(i)
        return res + [root.val]