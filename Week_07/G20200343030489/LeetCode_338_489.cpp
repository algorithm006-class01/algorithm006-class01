/*
 * @lc app=leetcode.cn id=338 lang=cpp
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> res(num+1);
        for(int i=1;i<=num;i++){
            if(i&1)
                res[i]=res[i-1]+1;
            else
                res[i]=res[i>>1];
        }
        return res;
    }
};
// @lc code=end

