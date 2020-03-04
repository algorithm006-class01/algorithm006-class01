/*
 * @lc app=leetcode id=874 lang=java
 *
 * [874] Walking Robot Simulation
 */

// @lc code=start
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
        int direction = 0;
        int[] endPoint = new int[2];
        int result = 0;
        Set<Long> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(((long) obstacle[0] + 90000) * 60000 + (long) obstacle[1] + 90000);
        }

        for (int command : commands) {
            if (command == -1) {
                direction = (direction + 3) % 4;
            } else if (command == -2) {
                direction = (direction + 1) % 4;
            } else {
                int steps = command;
                while (steps-- > 0) {
                    int nextEndPointX = endPoint[0] + directions[direction][0];
                    int nextEndPointY = endPoint[1] + directions[direction][1];
                    if (!obstacleSet.contains(((long) nextEndPointX + 90000) * 60000 + (long) nextEndPointY + 90000)) {
                        endPoint = new int[] { nextEndPointX, nextEndPointY };
                    }
                    result = Math.max(result, endPoint[0] * endPoint[0] + endPoint[1] * endPoint[1]);
                }
            }
        }
        return result;
    }
}
// @lc code=end
