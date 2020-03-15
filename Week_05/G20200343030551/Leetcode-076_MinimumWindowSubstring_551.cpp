#include <iostream>
#include <unordered_map>

using namespace std;

class Solution
{
public:
    string minWindow(string s, string t)
    {
        unordered_map<char, int> map;
        for (auto elem:t) map[elem]++;
        int left = 0;
        int cnt = 0;
        int max_len = s.size() + 1;
        int start = left;

        for (int i = 0; i < s.size(); i++)
        {
            if (--map[s[i]] >= 0)
                cnt++;
            while (cnt == t.size())
            {
                if (max_len > (i - left + 1))
                {
                    max_len = i - left + 1;
                    start = left;
                }
                //出现 包含于t集合的重复字符 于旧窗口中 窗口可变
                if (++map[s[left]] > 0) cnt--;
                left++;
            }
        }
        return max_len == (s.size() + 1) ? "" : s.substr(start, max_len);
    }
};