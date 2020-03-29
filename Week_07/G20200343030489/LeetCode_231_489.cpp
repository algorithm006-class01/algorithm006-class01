/*
 * @lc app=leetcode.cn id=231 lang=cpp
 *
 * [231] 2的幂
 */

// @lc code=start
class Solution {
public:
    bool isPowerOfTwo(int n) {
        if(n==0)
            return false;
        long x=n;
        return (x&(x-1))==0;
    }
};
// @lc code=end

