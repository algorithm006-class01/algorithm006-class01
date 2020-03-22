/*
 * @lc app=leetcode.cn id=455 lang=cpp
 *
 * [455] 分发饼干
 */

// @lc code=start
// class Solution {
// public:
//     int findContentChildren(vector<int>& g, vector<int>& s) {
//         if(g.size()==0)
//             return 0;
//         sort(s.begin(),s.end());
//         sort(g.begin(),g.end());
//         int num=0;
//         for (int i = 0; i < g.size(); i++)
//         {
//             for (int j = 0; j < s.size(); j++)
//             {
//                 if(s[j]>=g[i]){
//                     num++;
//                     s.erase(s.begin()+j);
//                     break;
//                 }
//             }
//             g.erase(g.begin()+i);
//             i--;
//         }
//         return num;
//     }
// };
class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        if(g.size()==0)
            return 0;
        sort(s.begin(),s.end());
        sort(g.begin(),g.end());
        int child=0;
        int cookie=0;
        while(child<g.size()&&cookie<s.size()){
            if(g[child]<=s[cookie])
                child++;
            cookie++;
        }
        return child;
    }
};
// @lc code=end

