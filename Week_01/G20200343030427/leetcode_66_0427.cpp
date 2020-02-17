//只有两种情况，1.个位数为9，
//1.1  考虑+1后进位；
//1.2 考虑进位后位数发生变化
//2.个位数不为9

class Solution {
public:
	vector<int> plusOne(vector<int>& digits) {

		for (int tail = digits.size() - 1; tail >= 0; tail--) {
			digits[tail] = (digits[tail] + 1) % 10;
			if (digits[tail] != 0)
				break;
			if (digits[tail] == 0) {
				if (tail == 0)
					digits.insert(digits.begin(), 1);
			}
		}
		return digits;
	}
};