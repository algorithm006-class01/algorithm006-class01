class Solution {
public:
	void moveZeroes(vector<int>& nums) {
		//双指针
		//快指针遇到非零直接覆盖慢指针
		//覆盖是O(1)
		int len = nums.size();
		int slow = 0;
		for (int fast = 0; fast < len; fast++) {
			if (nums[fast] != 0) {
				nums[slow] = nums[fast];
				slow++;
			}
		}
		//把后面都变为0
		for (int i = slow; i < len; i++) {
			nums[i] = 0;
		}
	}
};