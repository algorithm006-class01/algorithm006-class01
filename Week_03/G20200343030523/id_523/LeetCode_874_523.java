package greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/walking-robot-simulation
 */
public class WalkingRobotSimulation {

    public int robotSim(int[] commands, int[][] obstacles) {

        Set<String> set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            set.add(obstacles[i][0] + " " + obstacles[i][1]);
        }

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int d = 0, x = 0, y = 0;
        int result = 0;
        for (int command : commands) {
            if (command == -1) {
                d = (d + 1) % 4;
            } else if (command == -2) {
                d = (d - 1 + 4) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    if (!set.contains((x + directions[d][0]) + " " + (y + directions[d][1]))) {
                        x += directions[d][0];
                        y += directions[d][1];
                    }
                }
            }
            result = Math.max(result, x * x + y * y);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] commands = new int[]{4, -1, 4, -2, 4};
        int[][] obstacles = new int[][]{{2, 4}};

        WalkingRobotSimulation simulation = new WalkingRobotSimulation();
        System.out.println(simulation.robotSim(commands, obstacles));
    }

}
