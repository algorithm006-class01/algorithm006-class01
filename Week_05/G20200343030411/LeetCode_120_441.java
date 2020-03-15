/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int m = triangle.size();

        if (m == 0) return 0;

        int[][] states = new int[m][m];

        for (int i = 0; i < m; ++i) states[i][m-1] = triangle.get(m-1).get(i);

        for (int j = m-2; j >= 0; --j){
            for (int i = j; i >=0; --i){
                states[i][j] = Math.min(states[i][j+1], states[i+1][j+1]) + triangle.get(j).get(i);
            }
        }

        return states[0][0];
    }
}
// @lc code=end

