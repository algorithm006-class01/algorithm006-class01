/*
 * @lc app=leetcode.cn id=621 lang=java
 *
 * [621] 任务调度器
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] rows = new int[26];
        for (char task: tasks)
            rows[task - 'A'] ++;
        Arrays.sort(rows);
        int peak = rows[25] - 1;
        int space = peak * n;
        for (int i = 24; i >=0 && rows[i] > 0; i --) 
            space -= Math.min(rows[i], peak);
        return space > 0 ? space + tasks.length : tasks.length;
    }
}
// @lc code=end

