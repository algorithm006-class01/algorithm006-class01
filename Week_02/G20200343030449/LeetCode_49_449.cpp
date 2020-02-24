class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> key2strs;
        
        for (auto &i:strs) {
            auto temp = i;
            sort(temp.begin(),temp.end());
            auto iter = key2strs.find(temp);
            if (iter!=key2strs.end()) {
                iter->second.push_back(i);
            }
            else {
                vector<string> str;
                str.push_back(i);
                key2strs.insert(make_pair(temp,str));
            }
        }

        vector<vector<string>> result;
        for (auto &i:key2strs) {
            result.push_back(i.second);
        }

        return result;
    }
};
