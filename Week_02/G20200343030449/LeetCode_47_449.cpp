class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        sort(nums.begin(),nums.end());

        vector<vector<int>> result;
        vector<int> permute;
        bool* bUsed = new bool[nums.size()]();

        _permuteUnique(permute, bUsed, nums, result);

        delete[] bUsed;

        return result;
    }

    void _permuteUnique(vector<int> permute, bool* bUsed, const vector<int>& nums, vector<vector<int>>& result) {
        //Terminate
        if (permute.size() == nums.size()) {
            result.push_back(permute);
            return;
        }

        //Update Current Status
        for (int i = 0; i < nums.size();i++) {
            if ( i > 0 && nums[i-1]==nums[i] && !bUsed[i-1]) {
                continue;
            }
            
            if (!bUsed[i]) {
                permute.push_back(nums[i]);
                bUsed[i] = true;
                // Drill Down to next level
                _permuteUnique(permute, bUsed, nums, result);
                bUsed[i] = false;
                permute.pop_back();
            }
        }

        //Other
        return;
    }
};
