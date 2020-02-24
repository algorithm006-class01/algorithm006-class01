class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if(nums.size()==0) return;

        auto move = k%nums.size();

        reverse(nums, 0, nums.size());
        reverse(nums, 0, move);
        reverse(nums, move, nums.size());
    }

    void reverse(vector<int>& nums, int start, int end) {
        auto i = start;
        auto j = end-1;

        while (i<j) {
            nums[i] = nums[i]^nums[j];
            nums[j] = nums[i]^nums[j];
            nums[i] = nums[i]^nums[j];
            i++,j--;
        }

        return;
    }
};
