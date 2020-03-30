#include <algorithm>
#include <string>

using namespace std;

// 直接调用快排
class Solution {
public:
    bool isAnagram(string s, string t) {
        if ( s.size() != t.size() ) return false;
        sort(s.begin(), s.end());
        sort(t.begin(), t.end());
        for (int i = 0; i < s.size() && i < t.size(); i++){
            if (s[i] != t[i]) return false;
        }
        return true;
    }
};

//或者用哈希表,  统计不同字母的次数， 使用计数排序,