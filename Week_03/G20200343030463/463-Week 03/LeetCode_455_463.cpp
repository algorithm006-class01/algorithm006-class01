题目:分发饼干
解法如下 贪心算法

解法一:每次都满足未被分配的孩子
class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        
        sort(g.begin(),g.end());
        sort(s.begin(),s.end());
        int gx = 0;
        int sx = 0;
        while(gx<g.size() && sx<s.size()){
            if(g[gx] <= s[sx]) gx++;//当第gx个孩子满足之后 转移到下一个孩子的胃口
            sx ++;
        }
        return gx;
    }
};
