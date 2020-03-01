class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        dx = [0, 1, 0, -1]
        dy = [1, 0, -1, 0]

        x, y, direction, ans = 0, 0, 0, 0
        obstacleSet = set(map(tuple, obstacles))

        for cmd in commands:
            
            if cmd == -2:
                direction = (direction - 1) % 4
            elif cmd == -1:
                direction = (direction + 1) % 4
            else:
                for _ in range(cmd):
                    if (x+dx[direction], y+dy[direction]) not in obstacleSet:
                        x +=  dx[direction]
                        y +=  dy[direction]
                        ans = max(ans, x*x + y*y)
                
        return ans