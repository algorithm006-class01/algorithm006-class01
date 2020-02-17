class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.empty()) return 0;
        int first = 0,second = 1;
        for (; second < nums.size(); second++)
            nums[first] != nums[second] ? nums[++first] = nums[second] : first;
        return first + 1;
    }
};