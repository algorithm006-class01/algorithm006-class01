class Solution {
public:
	void rotate(vector<int>& nums, int k) {
		int len = nums.size();
		int temp, next;
		int count = 0;
		k = k % len;
		for (int start = 0; count < len; start++) {
			int prev = nums[start];
			int next = start;
			do {
				next = (next + k) % len;
				temp = nums[next];
				nums[next] = prev;
				prev = temp;
				count++;
			} while (start != next);
		}

		return;
	}
};