class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int zeroNums = 0;
        for(auto i = 0; i<nums.size();i++) {
            if (nums[i]==0) {
                    zeroNums++;
            }
            else {
                if (zeroNums!=0) {
                    nums[i-zeroNums] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }
};
