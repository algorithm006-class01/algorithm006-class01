class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(),g.end());
        sort(s.begin(),s.end());

        int i = 0;
        int j = 0;
        int count = 0;

        for(;i < g.size();i++) {
            while (j<s.size()) {
                if (g[i] <= s[j]) {
                    j++;
                    count++;
                    break;
                }
                j++;
            }
        }

        return count;
    }
};
