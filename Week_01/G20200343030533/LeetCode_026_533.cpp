//思路同C, 用C++写一遍
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() == 0 ) return 0;

        int fast = 0, slow = 0;
        for (; fast < nums.size(); fast++){
            if ( nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        slow++;
        return slow;
        
    }
};
