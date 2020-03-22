#
# @lc app=leetcode id=207 lang=python3
#
# [207] Course Schedule
#
# https://leetcode.com/problems/course-schedule/description/
#
# algorithms
# Medium (40.77%)
# Likes:    2932
# Dislikes: 146
# Total Accepted:    329.1K
# Total Submissions: 804.5K
# Testcase Example:  '2\n[[1,0]]'
#
# There are a total of n courses you have to take, labeled from 0 to n-1.
# 
# Some courses may have prerequisites, for example to take course 0 you have to
# first take course 1, which is expressed as a pair: [0,1]
# 
# Given the total number of courses and a list of prerequisite pairs, is it
# possible for you to finish all courses?
# 
# Example 1:
# 
# 
# Input: 2, [[1,0]] 
# Output: true
# Explanation: There are a total of 2 courses to take. 
# To take course 1 you should have finished course 0. So it is possible.
# 
# Example 2:
# 
# 
# Input: 2, [[1,0],[0,1]]
# Output: false
# Explanation: There are a total of 2 courses to take. 
# To take course 1 you should have finished course 0, and to take course 0 you
# should
# also have finished course 1. So it is impossible.
# 
# 
# Note:
# 
# 
# The input prerequisites is a graph represented by a list of edges, not
# adjacency matrices. Read more about how a graph is represented.
# You may assume that there are no duplicate edges in the input prerequisites.
# 
# 
#

# @lc code=start
from collections import deque
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if not numCourses:
            return False
        graph, indegrees = self.get_graph_and_indegrees(numCourses, prerequisites)
        start_courses = [c for c in range(numCourses) if indegrees[c] == 0]

        queue = deque(start_courses)
        visited = set()
        while queue:
            course = queue.popleft()
            visited.add(course)
            avaliable_courses = graph[course]
            for c in avaliable_courses:
                indegrees[c] -= 1
                if indegrees[c] == 0:
                    queue.append(c)
        
        return len(visited) == numCourses

    def get_graph_and_indegrees(self, numCourses: int, prerequisites: List[List[int]]):
        indegrees = {x: 0 for x in range(numCourses)}
        graph = {x: [] for x in range(numCourses)}
        for u, v in prerequisites:
            graph[v].append(u)
            indegrees[u] += 1
        return (graph, indegrees)

# @lc code=end

