import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=363 lang=java
 *
 * [363] 矩形区域不超过 K 的最大数值和
 */

// similar as 1074
// @lc code=start
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rl = matrix.length, cl = matrix[0].length, res = Integer.MIN_VALUE;
        for (int r = 0; r < rl; r ++) 
            for (int c = 1; c < cl; c ++)
                matrix[r][c] += matrix[r][c - 1];

        for (int c = 0; c < cl; c ++) {
            for (int _c = -1; _c < c; _c ++) {
                int s = 0;
                TreeSet<Integer> s_in_r = new TreeSet<>();
                s_in_r.add(s);
                for (int r = 0; r < rl; r ++) {
                    s += matrix[r][c] - (_c >= 0? matrix[r][_c] : 0);
                    Integer _s = s_in_r.ceiling(s - k);
                    if (_s != null) {
                        System.out.println(s - _s);
                        res = Math.max(res, s - _s);
                    }
                    s_in_r.add(s);
                }
            }
        }
        return res;
    }
}
// @lc code=end

