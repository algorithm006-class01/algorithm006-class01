package G20200343030015.week_03;

import java.util.HashSet;
import java.util.Set;

/**
 * 874. 模拟行走机器人
 * site:: https://leetcode-cn.com/problems/walking-robot-simulation/description/
 * Created by majiancheng on 2020/3/2.
 */
public class LeetCode_874_015 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0, max = 0;

        Set<String> obstacleSet = new HashSet<String>();
        for(int[] obstacle : obstacles) {
            obstacleSet.add(String.format("%d-%d", obstacle[0], obstacle[1]));
        }

        for(int cmd : commands) {
            if(cmd == -2) {
                di = (di + 3) % 4;
            } else if(cmd == -1) {
                di = (di + 1) % 4;
            } else {
                while(cmd-- > 0) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    if(!obstacleSet.contains(String.format("%d-%d", nx, ny))) {
                        x = nx;
                        y = ny;

                        max = Math.max(max, x*x + y*y);
                    }
                }
            }
        }
        return max;
    }
}
