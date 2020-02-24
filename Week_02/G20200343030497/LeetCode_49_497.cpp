/**
 * 49. 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 */


class Solution {
public:
    // 对每个元素按字母排序，然后当成键，存储在哈希表中，值为元素列表
    // 时间复杂度：O(nklogk)
    // 空间复杂度：O(nk)
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> mp;
        for(auto str:strs){
            string tmp = str;
            sort(tmp.begin(), tmp.end());
            mp[tmp].push_back(str);
        }

        vector<vector<string>> res;
        for(auto item:mp){
            res.push_back(item.second);
        }

        return res;
    }
};