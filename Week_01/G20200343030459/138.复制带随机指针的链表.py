#
# @lc app=leetcode.cn id=138 lang=python3
#
# [138] 复制带随机指针的链表
#
# https://leetcode-cn.com/problems/copy-list-with-random-pointer/description/
#
# algorithms
# Medium (47.18%)
# Likes:    225
# Dislikes: 0
# Total Accepted:    23.7K
# Total Submissions: 50.1K
# Testcase Example:  '[[7,null],[13,0],[11,4],[10,2],[1,0]]'
#
# 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
# 
# 要求返回这个链表的 深拷贝。 
# 
# 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
# 
# 
# val：一个表示 Node.val 的整数。
# random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
# 
# 
# 
# 
# 示例 1：
# 
# 
# 
# 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
# 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
# 
# 
# 示例 2：
# 
# 
# 
# 输入：head = [[1,1],[2,1]]
# 输出：[[1,1],[2,1]]
# 
# 
# 示例 3：
# 
# 
# 
# 输入：head = [[3,null],[3,0],[3,null]]
# 输出：[[3,null],[3,0],[3,null]]
# 
# 
# 示例 4：
# 
# 输入：head = []
# 输出：[]
# 解释：给定的链表为空（空指针），因此返回 null。
# 
# 
# 
# 
# 提示：
# 
# 
# -10000 <= Node.val <= 10000
# Node.random 为空（null）或指向链表中的节点。
# 节点数目不超过 1000 。
# 
# 
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

# 方法一： 用一个 hashmap
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return None
        mapping = self.get_mapping(head)
        self.copy_nodes(head, mapping)
        return mapping[head]

    def get_mapping(self, head):
        mapping = {}
        node = head
        while node:
            new_node = Node(node.val)
            mapping[node] = new_node
            node = node.next
        return mapping

    def copy_nodes(self, head, mapping):
        node = head
        while node:
            new_node = mapping[node]
            new_next, new_random = None, None
            if node.random:
                new_random = mapping[node.random]
            if node.next:
                new_next = mapping[node.next]
            new_node.next = new_next
            new_node.random = new_random
            node = node.next
        
# 方法二： 改变链表结构
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return None
        root = self.generate_new_head(head)
        while root:
            next_original = root.next.next
            root.next.next = next_original.next if next_original else None
            root.next.random = root.random.next if root.random else None
            root = next_original
        return head.next

    def generate_new_head(self, head):
        node = head
        while node:
            new_node = Node(node.val)
            new_node.next = node.next
            node.next = new_node
            node = new_node.next
        return head

# @lc code=end

