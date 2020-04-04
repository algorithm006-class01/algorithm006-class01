学习笔记
class Solution {
public:
    int myAtoi(string str) {
        long long int res = 0;
        string trim = str;
        bool sign = false;
        
        while(trim[0] == ' ')
            trim.erase(trim.begin());
        
        if(trim[0] == '-' || trim[0] == '+')
        {
            if(trim[0] == '-')
                sign = true;
            trim.erase(trim.begin());
        }
        
        for(char ch : trim)
        {
            if(!(ch >= '0' && ch <= '9'))
                break;
            
            res = res*10 + (ch-'0');
            if(res > INT_MAX)
                return (sign ? INT_MIN : INT_MAX);
        }
        
        if(sign)
            res = -1*res;
        return res;
    }
};
