package G20200343030391;

import java.util.HashSet;

public class  LeetCode_874_391 {

    public static void main(String[] args) {
        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2,4}};
        int i = new LeetCode_874_391().robotSim(commands, obstacles);
        System.out.println(i);

    }

    public int robotSim(int[] commands, int[][] obstacles) {
        //定义方向，初始方向为北，以顺时针方向依次定义： 北 0，东 1，南 2，西 3
        int direction = 0;
        // 定义数组，x轴或者y轴在每个方向前进一步走的距离，四个值分别对应北、东、南、西
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        //初始坐标
        int x = 0, y = 0;
        //障碍物存储
        HashSet<String> obstacleSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obstacleSet.add(obstacles[i][0] + "-" + obstacles[i][1]);
        }
        int max = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) {
                //右转，顺时针+1取模
                direction = (direction + 1) % 4;
            } else if (commands[i] == -2) {
                //左转，顺时针+3取模
                direction = (direction + 3) % 4;
            } else {
                //行进
                for (int j = 0; j < commands[i]; j++) {
                    int newX = x + dx[direction];
                    int newY = y + dy[direction];
                    if (!obstacleSet.contains(newX + "-" + newY)) {
                        //没有障碍
                        x = newX;
                        y = newY;
                        max = Math.max(max, x * x + y * y);
                    }
                }
            }
        }
        return max;
    }
}
