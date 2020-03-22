#
# @lc app=leetcode.cn id=22 lang=python
#
# [22] 括号生成
# 解题思路
# 1 递归 深度优先搜索
#   1. 先遍历左括号，然后左括号减一
#   2.判断右括号是否大于左括号，如果大于就输出右括号，然后右括号减一
#   3。判断左右括号是不是都输出了，如果是保存字符串结果
# 2 递归 广度优先搜索
# 解答 https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
#   1.一层一层的遍历节点，需要记录已经添加的节点，以及还未添加的节点
#   2.需要在每层记录的节点信息里面记录left, right，括号字符串状态
# @lc code=start
from collections import deque

class Node(object):
    def __init__(self, res='', left=0, right=0):
        self.res = res
        self.left = left
        self.right = right

        
class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        res = []
        queue = deque()
        queue.append(Node('', n, n))
        
        while queue:
            length = len(queue)
            
            for i in range(length):
                node = queue.pop()
                if node.left == 0 and node.right == 0:
                    res.append(node.res)
                
                if node.left > 0:
                    queue.append(Node(node.res + '(', node.left - 1, node.right))
                if node.right > 0 and node.right > node.left:
                    queue.append(Node(node.res + ')', node.left, node.right - 1))
                
        return res
            
        


# class Solution(object):
#     def generateParenthesis(self, n):
#         """
#         :type n: int
#         :rtype: List[str]
#         """
#         res = []
        
#         def _generate(str, left, right):
#             # terminator
#             if left == 0 and right == 0:
#                 res.append(str)
#                 return
            
#             if left > 0: _generate(str + "(", left - 1, right)
#             if right > left: _generate(str + ")", left, right - 1)
            
#         _generate('', n, n)
#         return res


# @lc code=end

