// 455. 分发饼干
// https://leetcode-cn.com/problems/assign-cookies/
class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());

        register int gi = 0, si = 0;
        while (gi < g.size() && si < s.size()){
            if ( g[gi] <= s[si]) gi++; //用最小的满足胃口最小
            si++; //无论是否满足，都换到下一个饼干
        }
        return gi;

    }
};