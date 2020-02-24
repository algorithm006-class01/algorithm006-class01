class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
		vector<vector<string>> results;
        unordered_map<string, int> map;
        int num = 0; //子vec在大vec中的下标, 
        for (int i = 0; i < strs.size(); i++) {
            string str = strs[i];
            sort(str.begin(), str.end());
            if (map.count(str)) {
				results[map[str]].push_back(strs[i]);
            }
            else {
                vector<string> vec(1, strs[i]);
                results.push_back(vec);
                map[str] = num++;
            }
        }
		return results;
    }
};