题目:字母异位词分组
思路:
001 将数组内每个元素都进行排序 排序得到的结果作为Key
002 将相同的Key对应的元素放入map中
003 然后将map元素遍历出来

解法:
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        
        unordered_map <string,vector<string>> map;
        
        for (auto s : strs){
            string t = s;
            sort(t.begin(),t.end());
            map[t].push_back(s);
        }
        
        vector<vector<string>> ans;
        for (auto c : map){
            ans.push_back(c.second);
        }
        
        return ans;
        
    }
};
