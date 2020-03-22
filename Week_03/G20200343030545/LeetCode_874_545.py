"""
    机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。
    该机器人可以接收以下三种类型的命令：
        -2：向左转 90 度
        -1：向右转 90 度
        1 <= x <= 9：向前移动 x 个单位长度

    在网格上有一些格子被视为障碍物。
    第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
    如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
    返回从原点到机器人的最大欧式距离的平方。

    示例 1：
        输入: commands = [4,-1,3], obstacles = []
        输出: 25
        解释: 机器人将会到达 (3, 4)

    示例 2：
        输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
        输出: 65
        解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 
    提示：
        0 <= commands.length <= 10000
        0 <= obstacles.length <= 10000
        -30000 <= obstacle[i][0] <= 30000
        -30000 <= obstacle[i][1] <= 30000
        答案保证小于 2 ^ 31
"""
from typing import List


class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        distance = dx = x = y = 0
        dy = 1
        obs_dict = dict()

        for obs in obstacles:
            obs_dict[tuple(obs)] = 0

        for com in commands:
            if com == -2:
                # 左转
                dx, dy = -dy, dx
            elif com == -1:
                # 右转
                dx, dy = dy, -dx
            else:
                # 走 或者 原地踏步
                for j in range(com):
                    next_x = x + dx
                    next_y = y + dy

                    if (next_x, next_y) in obs_dict:
                        break
                    x, y = next_x, next_y
                    distance = max(distance, x * x + y * y)
        return distance


if __name__ == '__main__':
    print(Solution().robotSim([-1, -2, 3], []))
