/*
 * @lc app=leetcode.cn id=49 lang=cpp
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> res;
        int line=0;
        string tmp;
        unordered_map<string,int> work;
        for (auto str:strs)
        {
            /* code */tmp=str;
            sort(tmp.begin(),tmp.end());
            if (work.count(tmp))
            {
                /* code */res[work[tmp]].push_back(str);
            }
            else
            {
                vector<string> vec(1,str);
                res.push_back(vec);
                work[tmp]=line++;
            }
            
            
        }
        return res;
    }
};
// @lc code=end

