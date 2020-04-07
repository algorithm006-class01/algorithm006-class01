/*
 * @lc app=leetcode.cn id=344 lang=cpp
 *
 * [344] 反转字符串
 */

// @lc code=start
// class Solution {
// public:
//     void reverseString(vector<char>& s) {
//         if(s.size()==1||s.size()==0)
//             return;
//         int size=s.size();
//         for(int i=0;i<size/2;i++){
//             if(s[i]==s[size-1-i])
//                 continue;
//             char tmp=s[size-1-i];
//             s[size-1-i]=s[i];
//             s[i]=tmp;
//         }
        
//     }
// };
class Solution {
public:
    void reverseString(vector<char>& s) {
        int size=s.size();
        for(int i=0;i<size/2;i++){
            if(s[i]==s[size-1-i])
                continue;
            swap(s[i],s[size-1-i]);
        }
    }
};
// @lc code=end

