#include <string>
#include <limits.h>

using std::string;

class Solution {
public:
    int myAtoi(string str) {
        int res = 0;
        int i = 0;
        int flag = 1;
        while (str[i] == ' '){
            i++;
        }
        if ( str[i] == '+'){
            flag = 1;
            i++;
        } else if ( str[i] == '-'){
            flag = 0;
            i++;
        } else if ( str[i] > '9' || str[i] < '0') {
            return 0;
        }

        for ( ; i < str.size(); i++){
            if ( str[i] < '0' || str[i]> '9') break;
            if ( res > INT_MAX / 10 || ( res == INT_MAX / 10 && (str[i]-'0') > INT_MAX %10 )){
                return INT_MAX;
            }
            if ( res < INT_MIN / 10 || ( res == INT_MIN / 10 && (str[i]-'0') > -(INT_MIN %10 ))){
                return INT_MIN;
            }
            res = res * 10 + flag*(str[i] - '0');
        }

        return res;
        
    }
};