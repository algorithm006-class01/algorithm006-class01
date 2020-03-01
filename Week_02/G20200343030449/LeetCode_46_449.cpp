class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        int size = nums.size();
        bool* usedNums = new bool[size]();
        vector<vector<int>> result;
        vector<int> num;

        _permute(num,usedNums,nums,result);

        delete[] usedNums;

        return result;
    }

    void _permute(vector<int> num, bool usedNums[], const vector<int>& nums, vector<vector<int>>& result) {
        // terminate
        if (num.size() >= nums.size()) {
            result.push_back(num);
            return;
        }

        // next level
        for (auto i = 0; i < nums.size();i++) {
            if (usedNums[i]==false) {
                usedNums[i]=true;
                num.push_back(nums[i]);
                _permute(num, usedNums, nums, result);
                usedNums[i]=false;
                num.pop_back(); 
            }
        }

        //other status
        return;
    }
};
