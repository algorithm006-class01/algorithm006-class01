# -*- coding:utf-8 -*-
# @lc app=leetcode.cn id=773 lang=python
#
# [773] 滑动谜题
#
# 解题思路
# 1.BFS
#   1.生成0元素移动的映射关系。整个board生成字符串形式方便处理
#   2.每次移动上下左右4个方向，找到对应的结果添加到新的list再进行一层循环
# 2.A*
#   1.与BFS的变化就是使用priorityqueue和估价函数


# @lc code=start
# A* manhattan distance
# import heapq

# class Solution(object):
#     def slidingPuzzle(self, board):
#         """
#         :type board: List[List[int]]
#         :rtype: int
#         """
#         # 取当前board所有分值的和, 当前点值到最终位置的曼哈顿距离，把这个棋盘的每个子都计算一遍求和
#         def get_score(board):
#             return sum([scores[int(board[i * 3 + j])][i][j] for i in range(2) for j in range(3)])

        
#         goal_pos = {1:(0,0), 2:(0,1), 3:(0,2), 4:(1,0), 5:(1,1), 0:(1,2)}
#         scores = [0] * 6
#         # 估价函数的目的就是求当前值在每个位置时和目标位置的曼哈顿距离
#         for num in range(6):
#             scores[num] = [[abs(goal_pos[num][0] - i)+abs(goal_pos[num][1] - j) for j in range(3)] for i in range(2)]
        
#         moves = {0:{1,3}, 1:{0,2,4}, 2:{1,5},3:{0,4},4:{1,3,5}, 5:{2,4}}
#         used = set()

#         q = []
#         s = "".join([str(c) for row in board for c in row])
        
#         heapq.heappush(q, (0, (0, s, s.index('0'))))
        
#         while len(q):
#             _, (distance, s, i) = heapq.heappop(q)
#             if s == '123450':
#                 return distance
#             arr = [c for c in s]
#             for move in moves[i]:
#                 new_arr = arr[:]
#                 new_arr[move], new_arr[i] = new_arr[i], new_arr[move]
#                 new_s = "".join(new_arr)
#                 if new_s not in used:
#                     used.add(new_s)
#                     # print(new_s, s)
#                     heapq.heappush(q, (get_score(new_s) + distance + 1, (distance + 1, new_s, move)))
            
#         return -1
        
        
#BFS
# class Solution(object):
#     def slidingPuzzle(self, board):
#         """
#         :type board: List[List[int]]
#         :rtype: int
#         """
#         # [[1,2,3],[4,0,5]]
#         moves = {0:{1,3}, 1:{0,2,4},2:{1,5},3:{0,4},4:{1,3,5}, 5:{2,4}}
#         used = set()
#         cnt = 0
        
#         s = "".join(str(c) for row in board for c in row)
#         q = [(s, s.index("0"))]
#         while q:
#             new = []
#             for s, i in q:
#                 used.add(s)
#                 if s == '123450':
#                     return cnt
#                 arr = [c for c in s]
#                 for move in moves[i]:
#                     new_arr = arr[:]
#                     new_arr[move], new_arr[i] = s[i], s[move]
#                     new_s = "".join(new_arr)
#                     if new_s not in used:
#                         new.append((new_s, move))
#             q = new
#             cnt += 1
#         return -1
        
        
# class Solution:
#     def slidingPuzzle(self, board):
#         # 使用一个字典来描述0在各个位置可以移动的位置
#         moves, used, cnt = {0: {1, 3}, 1:{0, 2, 4}, 2:{1, 5}, 3:{0, 4}, 4:{1, 3, 5}, 5:{2, 4}}, set(), 0
#         # 将数组转化为字符串
#         s = "".join(str(c) for row in board for c in row)
#         # 字符串和0 的位置
#         q = [(s, s.index("0"))]
#         while q:
#             new = []
#             for s, i in q:
#                 used.add(s)
#                 if s == "123450":
#                     return cnt
#                 arr = [c for c in s]
#                 for move in moves[i]:
#                     new_arr = arr[:]
#                     # 新的位置
#                     new_arr[i], new_arr[move] = new_arr[move], new_arr[i]
#                     new_s = "".join(new_arr)
#                     if new_s not in used:
#                         new.append((new_s, move))
#             cnt += 1
#             q = new
#         return -1

# 3*3 board
class Solution:
    def slidingPuzzle(self, board):
        # 使用一个字典来描述0在各个位置可以移动的位置
        moves = {0: {1, 3}, 1:{0, 2, 4}, 2:{1, 5}, 3:{0, 4, 6}, 4:{1, 3, 5, 7}, 5:{2, 4, 8}, 6:{3,7}, 7:{4,6,8}, 8:{5,7}}
        used = set()
        cnt = 0
        
        # 将数组转化为字符串
        s = "".join(str(c) for row in board for c in row)
        # 字符串和0 的位置
        q = [(s, s.index("0"))]
        while q:
            new = []
            for s, i in q:
                used.add(s)
                if s == "123456780":
                    return cnt
                arr = [c for c in s]
                for move in moves[i]:
                    new_arr = arr[:]
                    # 新的位置
                    new_arr[i], new_arr[move] = new_arr[move], new_arr[i]
                    new_s = "".join(new_arr)
                    if new_s not in used:
                        new.append((new_s, move))
            cnt += 1
            q = new
        return -1

# import itertools
# import collections

# class Solution(object):
#     def slidingPuzzle(self, board):
#         R, C = len(board), len(board[0])
#         # 将list转化为单个字符的tuple
#         start = tuple(itertools.chain(*board))
#         # start 为tuple，start.index(0), 第一个元素，stpe =0
#         queue = collections.deque([(start, start.index(0), 0)])
#         seen = {start}
#         # python3不支持，生成一个tuple末尾元素是0
#         target = tuple(range(1, R*C) + [0])

#         while queue:
#             board, posn, depth = queue.popleft()
#             if board == target: return depth
#             # -1 1 左右，-C C 为col的长度
#             for d in (-1, 1, -C, C):
#                 nei = posn + d
#                 # 验证新位置合理性
#                 if abs(nei/C - posn/C) + abs(nei%C - posn%C) != 1:
#                     continue
#                 if 0 <= nei < R*C:
#                     newboard = list(board)
#                     newboard[posn], newboard[nei] = newboard[nei], newboard[posn]
#                     newt = tuple(newboard)
#                     if newt not in seen:
#                         seen.add(newt)
#                         queue.append((newt, nei, depth+1))

#         return -1

# @lc code=end
if __name__ == "__main__":
    obj = Solution()
    # ret = obj.slidingPuzzle([[1,2,3],[4,5,6],[7,8,0]])
    ret = obj.slidingPuzzle([[0,1,2],[3,4,5],[6,7,8]])
    print(ret)