/*
 * @lc app=leetcode.cn id=917 lang=cpp
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
class Solution {
public:
    string reverseOnlyLetters(string S) {
        int begin=0;
        int end=S.size()-1;
        while(begin<end){
            while(begin<end&&!isalpha(S[begin]))
                begin++;
            while(begin<end&&!isalpha(S[end]))
                end--;
            if(begin<end){
                swap(S[begin],S[end]);
                begin++;end--;
            }
        }
        return S;
    }
};
// @lc code=end

