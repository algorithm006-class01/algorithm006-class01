package com.home.work.week03;

import java.util.Set;

public class LeetCode_874_587 {
    public int robotSim(int[] commands, int[][] obstacles) {
        //x y 移动的项量 北0 东1 南2 西3
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        //方向di 初始值:北,机器人 移动的距离 x y
        int di = 0, x = 0, y = 0;
        //结果
        int ans = 0;
        //障碍物
        Set<String> obstacle = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacle.add(obs[0] + "-" + obs[1]);
        }

        for (int c : commands) {
            if (c == -1) di = (di + 1) % 4;
            else if (c == -2) di = (di + 3) % 4;
            else{
                for (int j = 0; j < c; j++) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    //有障碍退出
                    if (obstacle.contains(nx + "-" + ny)) break;
                    //无障碍 计算欧式距离的平方 a = x^2 + y^2
                    x = nx;
                    y = ny;
                    ans = Math.max(ans,x * x + y * y);
                }
            }
        }
        return ans;
    }
}
