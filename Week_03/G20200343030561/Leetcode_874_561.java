import java.util.*;
/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 北东南西
        int dirIdx = 0, x = 0, y = 0, nextX, nextY, res = 0;


        Set<String> obstaclesSet = new HashSet<>();
        for (int k = 0; k < obstacles.length; k ++) {
            obstaclesSet.add(obstacles[k][0] + "," + obstacles[k][1]);
        }

        for (int i = 0; i < commands.length; i ++) {
            int com = commands[i];
            switch (com) {
                case -1:
                    dirIdx = (dirIdx + 1) % 4; // 右转
                    break;
                case -2:
                    dirIdx = (dirIdx + 3) % 4; // 左转
                    break;
                default:
                    for (int j = 1; j <= com; j++) {
                        nextX = x + dir[dirIdx][0];
                        nextY = y + dir[dirIdx][1];
                        if (!obstaclesSet.contains(nextX + "," + nextY)){
                          x = nextX;
                          y = nextY;
                          res = Math.max(res, x*x + y*y);
                        }
                    }
            }
        }
        return res;
    }
}
// @lc code=end

