import week02.leetcode_236


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def bsf(self, nodes):
        if len(nodes) == 0:
            return []
        vals = []
        temp = []  # 存储下一层
        tempvals = []
        for node in nodes:
            if node.val is not None:
                tempvals.append(node.val)
            if node.left:
                temp.append(node.left)
            if node.right:
                temp.append(node.right)
        vals.append(tempvals)
        children = self.bsf(temp)
        if len(children) > 0:
            vals = vals + children
        return vals


    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        children = [root]
        return self.bsf(children)


l = [3, 5, 1, 6, 2, 0, 8, None, None, 7, 4]
# l = [3, 9, 20, None, None, 15, 7]
if len(l):
    r = TreeNode(l[0])
    week02.leetcode_236.buildtree([r], l[1:])
    solution = Solution()
    print("------------------")
    print("result:", solution.levelOrder(r))

# result: [[3], [5, 1], [6, 2, 0, 8], [7, 4]]
# result: [[3], [9, 20], [15, 7]]