class Solution {
public:
    inline void ltrim(std::string &s) {
        s.erase(s.begin(), std::find_if(s.begin(), s.end(), [](int ch) {
        return !std::isspace(ch);}));
    }

    inline void rtrim(std::string &s) {
        s.erase(std::find_if(s.rbegin(),s.rend(),[](int ch) {
            return !std::isspace(ch);
        }).base(), s.end());
    }

    int myAtoi(string str) {
        ltrim(str);
        rtrim(str);

        if (str.size()==0) {
            return 0;
        }

        int start = 0;
        bool isNegative = false;
        int ans = 0;

        if (str[start]=='-') {
            isNegative = true;
        }

        if (str[start]=='-' || str[start]=='+') {
            start++;
        }

        if (start >= str.size()) {
            return 0;
        }

        if (str[start] < '0'||str[start] > '9') {
            return 0;
        }

        unsigned long tmp = 0;
        while (str[start] >= '0' && str[start] <= '9' && start<str.size()) {
            unsigned long num = str[start]-'0';
            if (tmp*10+num >= (unsigned long)INT_MAX+1) {
                cout << "Overflow!:"<< tmp << endl;
                tmp = (unsigned long)INT_MAX+1;
                break;
            }

            tmp=(unsigned long)(tmp*10)+num;

            start++;
        }

        cout << "temp:"<< tmp << endl;

        if (isNegative) {
            ans = ~tmp+1;
        }

        if (!isNegative) {
            if (tmp > INT_MAX) {
                ans = INT_MAX;
            }
            else {
                ans = static_cast<int>(tmp);
            }
        }

        return ans;
    }
};
