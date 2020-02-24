"""
    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
    满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

    例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
    示例 1:
        输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        输出: 3
        解释: 节点 5 和节点 1 的最近公共祖先是节点 3。

    示例 2:
        输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
        输出: 5
        解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
    说明:

    所有节点的值都是唯一的。
    p、q 为不同节点且均存在于给定的二叉树中。
"""


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.recursive(root, p, q)

    @classmethod
    def use_hash(cls, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        """
            使用哈希保存遍历过的节点  key是子节点，value是父节点
            循环遍历只到p 和 q节点都出现在哈希表中。

            然后构建一个set(元素唯一)，
            将p的祖宗这条线都加到set里

            然后遍历q，找到q的祖先在set中第一次出现的节点
            就是最先公共祖先。
            时间复杂度：O(n) 空间复杂度：O(n)
        """
        hash_map = {root: None}
        stack = [root]

        while p not in hash_map or q not in hash_map:
            node = stack.pop()

            if node.left:
                hash_map[node.left] = node
                stack.append(node.left)
            if node.right:
                hash_map[node.right] = node
                stack.append(node.right)

        set_ = set()

        while p:
            set_.add(p)
            p = hash_map[p]

        while q not in set_:
            q = hash_map[q]

        return q

    @classmethod
    def recursive(cls, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        """
            时间复杂度：O(n)，空间复杂度：O(n)
            如果root 或者root等于p或者q，直接返回root就行
            然后递归下去，
                如果left为空，那只能在right上找
                如果right为空，那只能在left上咋后
                如果left right都为空，那直接返回空
        """

        if not root or (root == p or root == q):
            return root

        left = cls.recursive(root.left, p, q)
        right = cls.recursive(root.right, p, q)

        if not left:
            return right

        if not right:
            return left

        if left and right:
            return root
