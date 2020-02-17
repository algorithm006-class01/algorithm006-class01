class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int size=digits.size();
        for (int i = size-1; i >=0; i--)
        {
            /* code */if (digits[i]==9)
            {
                /* code */digits[i]=0;
            }
            else
            {
                digits[i]++;
                return digits;
            }
            
            
        }
        digits.push_back(0);
        digits[0]=1;
        return digits;
        
    }
};