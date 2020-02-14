class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> var2index;

        for (auto i = 0; i < nums.size(); i++) {
            auto iter = var2index.find(target-nums[i]);
            if (iter!=var2index.end()) {
                return vector<int>({iter->second, i});
            }

            var2index.insert(make_pair(nums[i],i));
        }

        return vector<int>(0);
    }
};
