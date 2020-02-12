class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        stack<int> resultTemp;
        vector<int> result;

        if (digits.size()==0) {
            digits.push_back(0);
        }

        auto isIncrement = true;

        for (int i = digits.size()-1; i >= 0; i--) {
            auto num = digits[i];

            isIncrement?num++:num;

            if (num > 9) {
                isIncrement = true;
                num -= 10;
            }
            else {
                isIncrement = false;
            }

            resultTemp.push(num);
        }

        if (isIncrement) {
            resultTemp.push(1);
        }
        
        while (!resultTemp.empty()) {
            auto i = resultTemp.top();
            resultTemp.pop();
            result.push_back(i);
        }

        return result;
    }
};


