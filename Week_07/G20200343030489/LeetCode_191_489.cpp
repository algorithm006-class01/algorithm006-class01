/*
 * @lc app=leetcode.cn id=191 lang=cpp
 *
 * [191] 位1的个数
 */

// @lc code=start


class Solution {
public:
    int hammingWeight(uint32_t n) {
        int num=0;
        while(n!=0){
            num++;
            n&=(n-1);
        }
        return num;
    }
};

// @lc code=end

