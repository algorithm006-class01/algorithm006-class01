#include <string>

using std::string;

class Solution {
public:
    bool isIsomorphic(string s, string t) {
        int ss[128] = {0};
        int tt[128] = {0};
        int sc = 0, tc = 0;
        for (int i = 0; i < s.size(); i++){
            if ( ss[s[i]] == 0) ss[s[i]] = ++sc;
            if ( tt[t[i]] == 0) tt[t[i]] = ++tc;
            if ( ss[s[i]] != tt[t[i]]) return false;
        }

        return true;

    }
};