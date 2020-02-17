class Solution {
public:
	int trap(vector<int>& height) {
		stack<int> sta;
		int sumArea = 0;
		int len = height.size();
		for (int i = 0; i < len; i++) {
			int right = i;
			while (!sta.empty() && height[right] > height[sta.top()]) {
				int bottom = sta.top();
				sta.pop();
				if (sta.empty())
					break;
				int left = sta.top();
				sumArea += (min(height[left], height[right]) - height[bottom]) * (right - left - 1);
			}
			sta.push(i);
		}
		return sumArea;
	}
};