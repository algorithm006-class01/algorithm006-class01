import java.util.*;
/*
 * @lc app=leetcode.cn id=1091 lang=java
 *
 * [1091] 二进制矩阵中的最短路径
 */

// @lc code=start
// @date Mar 22 2020
// @solution a*
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int rl = grid.length, cl = grid[0].length;
        if (grid[0][0] == 1 || grid[rl - 1][cl - 1] == 1) return -1;
        int[][] dir = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-1, 1}, {-1, -1}, {1, -1}, {1, 1}
        };
        int[] step = new int[rl * cl];
        for (int i = 0; i < rl * cl; i ++) 
            step[i] = Integer.MAX_VALUE;
        Comparator<Integer> manhattan = (pos1, pos2) -> {
            int r1 = pos1 / cl, c1 = pos1 % cl;
            int r2 = pos2 / cl, c2 = pos2 % cl;
            int mht1 = Math.max(Math.abs(rl - 1 - r1) , Math.abs(cl - 1 - c1));
            int mht2 = Math.max(Math.abs(rl - 1 - r2) , Math.abs(cl - 1 - c2));
            // if (Math.abs((mht1 + step[pos1]) - (mht2 + step[pos2])) <= (int)Math.sqrt((double)rl)) 
            //     return 0;
            // return (mht1 + step[pos1]) - (mht2 + step[pos2]);
            // return mht1 - mht2;
            return step[pos1] - step[pos2];
        };
        // Comparator<Integer> euclidean = (pos1, pos2) -> {
        //     int r1 = rl - 1 - pos1 / cl, c1 = cl - 1 - pos1 % cl;
        //     int r2 = rl - 1 - pos2 / cl, c2 = cl - 1 - pos2 % cl;
        //     double distance1 = Math.sqrt((r1)*(r1) +(c1)*(c1));
        //     double distance2 = Math.sqrt((r2)*(r2) +(c2)*(c2));
        //     //return Double.compare((distance1 + (double)step[pos1]), (distance2 + (double)step[pos2]));
        //     return Double.compare((distance1), (distance2));
        // };
        PriorityQueue<Integer> queue = new PriorityQueue<>(manhattan);
        queue.offer(0);
        step[0] = 1;
        grid[0][0] = 1;
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            // System.out.println(pos);
            // System.out.println(step[pos]);
            // System.out.println("===========");
            if (pos == rl * cl - 1) return step[pos];
            int _r = pos / cl, _c = pos % rl;
            for (int[] d : dir) {
                int r = _r + d[0];
                int c = _c + d[1];
                if (r < 0 || c < 0 || r >= rl || c >= cl) continue;
                if (grid[r][c] == 0) {
                    step[r * cl + c] = Math.min(step[pos] + 1, step[r * cl + c]);
                    // step[r * cl + c] = step[pos] + 1;
                    queue.offer(r * cl + c);
                    grid[r][c] = 1;
                }
            }
        }
        return -1;
    }
}
// 
// @lc code=end

