class Solution {
public:
	vector<int> twoSum(vector<int>& nums, int target) {
		unordered_map<int, int> map;
		for (int i = 0; i< nums.size(); i++) {

			if (map.find(target - nums[i]) != map.end())
				return { i, map[target - nums[i]] }; //{i, map[target - nums[i]]}或者{map[target - nums[i]], i}都可以
			map[nums[i]] = i;
		}
		return {};
	}
};