/*
 * @lc app=leetcode.cn id=709 lang=cpp
 *
 * [709] 转换成小写字母
 */

// @lc code=start
// class Solution {
// public:
//     string toLowerCase(string str) {
//         for(int i=0;i<str.size();i++)
//             if(str[i]>='A'&&str[i]<='Z')
//                 str[i]=str[i]+32;
//         return str;
//     }
// };
class Solution {
public:
    string toLowerCase(string str) {
        for(char& a:str)
            if(a>='A'&&a<='Z')
                a=a+32;    
        return str;
    }
};
// @lc code=end

