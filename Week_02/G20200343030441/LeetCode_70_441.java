/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {

        //递归方案超时
        // if (n == 0){
        //     return 0;
        // }
        // if (n == 1){
        //     return 1;
        // }
        // if (n == 2){
        //     return 2;
        // }
        // return climbStairs(n-1) + climbStairs(n-2);
            
        // 方案一: f1=1, f2=2, f3=f2+f1, f4=f3+f2
        if (n <= 2){
            return n;
        }
        int f1 = 1, f2 = 2;
        int paths_num = 0;
        for (int i = 3; i <= n; ++i){
            paths_num = f2 + f1;
            f1 = f2;
            f2 = paths_num;
        }
        return paths_num;
    }
}
// @lc code=end

