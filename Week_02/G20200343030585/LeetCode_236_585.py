#
# @lc app=leetcode.cn id=236 lang=python
#
# [236] 二叉树的最近公共祖先
# 解题思路
# 1.递归
#   1.从根节点找起，如果找到要找的节点就返回True
#   2。如果当前节点的两边都找到了当前节点，第一个查到的就是公共祖先
#   3。如果当前节点就是要找的节点，同时其子节点也找到了其中一个元素证明当前节点为公共祖先
# 复杂度分析
# 时间复杂度：O(N)，N 是二叉树中的节点数，最坏情况下，我们需要访问二叉树的所有节点。
# 空间复杂度：O(N)，这是因为递归堆栈使用的最大空间位 N,斜二叉树的高度可以是 N。
# 2.递归
#  1.先找到q和p节点的所有父节点存入字典，字典保存父子关系
#  2.导出所有p的父节点，查找q节点的父节点是否在q的父节点里面

# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        parent = collections.defaultdict()
        # 添加root节点
        parent[root] = None
        st = [root]
        
        while p not in parent or q not in parent:
            node = st.pop()
            
            if node.left:
                parent[node.left] = node
                st.append(node.left)
            if node.right:
                parent[node.right] = node
                st.append(node.right)
                
        ancestors = set()
        
        while p:
            ancestors.add(p)
            p = parent[p]
            
            
        while q not in ancestors:
            q = parent[q]
            
        return q
            


# class Solution(object):
#     def lowestCommonAncestor(self, root, p, q):
#         """
#         :type root: TreeNode
#         :type p: TreeNode
#         :type q: TreeNode
#         :rtype: TreeNode
#         """
#         if root is None:
#             return []
#         ans = None
        
#         def search(node):
#             if node is None:
#                 return False
            
#             # 在左子树 or 右子树是否找到p，q
#             left = search(node.left)
#             right = search(node.right)
                       
#             mid = False
#             # 如果当前元素为q，p其中一个的时候
#             if node == p or node == q:
#                 mid = True
            
#             # 当前元素的子树找到了q，p
#             # 当前元素为其中之一 同时子树里面找到另外一个
#             if mid + left + right >= 2:
#                 self.ans = node
            
#             # 任何一个方向找到了 or 当前找到了都是这条路径上找到了
#             return mid or left or right
            
#         search(root)
#         return self.ans
             
                
        
        
# @lc code=end

