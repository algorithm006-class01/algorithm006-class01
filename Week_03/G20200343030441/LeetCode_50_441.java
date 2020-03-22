/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, long n) {
        // 1.暴力法

        // 2.分治
        if (n < 0){
            n = -n;
            x = 1/x;
        }
        return _pow(x, n);
    }

    private double _pow(double x, long n){
        if (n == 0){
            return 1.0;
        }

        double half = _pow(x, n/2);

        if (n % 2 == 0){
            return half * half;
        }else {
            return half * half * x;
        }
        
    }
}
// @lc code=end

