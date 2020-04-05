/*
 * @lc app=leetcode.cn id=205 lang=cpp
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
public:
    bool isIsomorphic(string s, string t) {
        if(s.size()!=t.size())
            return false;
        for(int i=0;i<s.size();i++){
            if(s.find(s[i])!=t.find(t[i]))
                return false;
        }
        return true;
    }
};
// @lc code=end

