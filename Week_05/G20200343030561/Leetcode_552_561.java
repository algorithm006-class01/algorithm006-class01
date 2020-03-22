/*
 * @lc app=leetcode.cn id=552 lang=java
 *
 * [552] 学生出勤记录 II
 */

// @lc code=start
class Solution {
    public int checkRecord(int n) {
        int MOD = 1000000007;
        long a0l0 = 1;
        long a0l1 = 0;
        long a0l2 = 0;
        long a1l0 = 0;
        long a1l1 = 0;
        long a1l2 = 0;
        long _a0l0;
        long _a0l1;
        long _a0l2;
        long _a1l0;
        long _a1l1;
        long _a1l2;
        for (int i = 0; i < n + 1; i ++) {
            _a0l0 = a0l0 + a0l1 + a0l2;
            _a0l1 = a0l0;
            _a0l2 = a0l1;
            _a1l0 = a1l0 + a1l1 + a1l2 + _a0l0;
            _a1l1 = a1l0;
            _a1l2 = a1l1;
            a0l0 = (_a0l0) % MOD;
            a0l1 = _a0l1;
            a0l2 = _a0l2;
            a1l0 = (_a1l0) % MOD;
            a1l1 = _a1l1;
            a1l2 = _a1l2;
        }
        return (int)a1l0;
    }
}
// @lc code=end

