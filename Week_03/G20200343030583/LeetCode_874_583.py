#
# @lc app=leetcode id=874 lang=python
#
# [874] Walking Robot Simulation
#

# @lc code=start
class Solution(object):
    def robotSim(self, commands, obstacles):
        """
        :type commands: List[int]
        :type obstacles: List[List[int]]
        :rtype: int
        """
        # draw a square with arrows and you will know the array
        dx = [0,1,0,-1]
        dy = [1,0,-1,0]
        obstacleSet = set(map(tuple,obstacles))
        x,y= 0,0
        di = 0    
        max_disatance = 0
        for c in commands:
            if c == -2:
                di = (di - 1) % 4
            elif c == -1:
                di = (di + 1) % 4
            else:
                for _ in xrange(c):
                    if (x+dx[di], y +dy[di]) not in obstacleSet:
                        x += dx[di]
                        y += dy[di]
                        max_disatance = max(max_disatance, x*x+y*y)
                    else:
                        break
        return max_disatance
# @lc code=end

