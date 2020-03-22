
/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 *
 * https://leetcode-cn.com/problems/walking-robot-simulation/description/
 *
 * algorithms
 * Easy (32.32%)
 * Likes:    75
 * Dislikes: 0
 * Total Accepted:    5.9K
 * Total Submissions: 18.1K
 * Testcase Example:  '[4,-1,3]\n[]'
 *
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * 
 * 
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 
 * 
 * 在网格上有一些格子被视为障碍物。
 * 
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * 
 * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * 
 * 返回从原点到机器人的最大欧式距离的平方。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 
 * 
 * 示例 2：
 * 
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * 答案保证小于 2 ^ 31
 * 
 * 
 */
/*
 * 思路：关键点1. 如何表示方向，更方便运算；
 *           2. 如何快速判断一个坐标位置是否有障碍物；
 *           3. 除了一次移动一格之外，有无更快速的识别路途障碍物的办法？
 * 
 * PS: 1.借鉴了题解中方向的表示方式；
 *     2.障碍物的位置，开始使用的是Set中是String类型，性能低，转为long类型；
 */
// @lc code=start
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 北，东，南，西
        int maxDistance = 0, posX = 0, posY = 0, dIndex = 0;

        // Set<String> obstaclesSet = new HashSet<String>();
        // for (int[] obstacle : obstacles) {
        //     obstaclesSet.add(String.format("%d,%d", obstacle[0], obstacle[1]));
        // }
        Set<Long> obstaclesSet = new HashSet();
        for (int[] obstacle : obstacles) {
            long ox = (long)(obstacle[0] + 30000);
            long oy = (long)(obstacle[1] + 30000);
            obstaclesSet.add((ox << 16) + oy);
        }

        for (int command : commands) {
            if (-1 == command)
                dIndex = (dIndex + 1) % 4;
            else if (-2 == command)
                dIndex = (dIndex + 3) % 4;
            else {
                int validStep = command;
                for (int i = 1; i <= command; i++) {
                    int nextPosX = posX + i * dirs[dIndex][0];
                    int nextPosY = posY + i * dirs[dIndex][1];
                    long nextPos = ((long)(nextPosX + 30000) << 16) + (long)(nextPosY + 30000);
                    if (obstaclesSet.contains(nextPos)) {
                        validStep = i - 1;
                        break;
                    }
                }
                posX = posX + validStep * dirs[dIndex][0];
                posY = posY + validStep * dirs[dIndex][1];
                maxDistance = Math.max(maxDistance, posX * posX + posY * posY);
            }
        }
        return maxDistance;
    }
}
// @lc code=end

