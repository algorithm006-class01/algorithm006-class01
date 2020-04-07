#include <unordered_map>
#include <string>
#include <iostream>

using std::unordered_map;
using std::string;
using std::cout;
using std::endl;

class Solution {
public:
    int firstUniqChar(string s) {
        unordered_map<char, int> dict;
        for (auto ch : s){
            if (dict.find(ch) == dict.end()){
                dict[ch] = 1;
            } else{
                dict[ch]++;
            }
        }
        for (int i = 0; i < s.size(); i++){
            if ( dict[s[i]] == 1) {
                return i;
            }
        }
        return -1;

    }
    int firstUniqChar2(string s) {
        int dict[26] = {0};
        for ( auto ch : s){
            dict[ch-'a']++;
        }
        for (int i =0; i < s.size(); i++){
            if (dict[s[i]-'a'] == 1) return i;
        }
        return -1;

    }
};

int main(int argc, char const *argv[])
{
    Solution sol;
    cout << sol.firstUniqChar("leetcode") << endl;
    cout << sol.firstUniqChar("abcedf") << endl;
    cout << sol.firstUniqChar("loveleetcodde") << endl;
    return 0;
}
