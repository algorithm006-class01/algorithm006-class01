class Solution {
public:
    string reverseStr(string s, int k) {
        //int len = strlen(s);
        int len = s.size();
        for (int i = 0; i < len; i+=k*2) { 
            if (i+k <= len) s = overturn(s, i, i+k);
            else            s = overturn(s, i, len);
        }
        return s;
    }
    string overturn(string str, int fast, int last)
    {
        int i = fast;
        int j = last - 1;
        while (i < j) {
            str[i]   ^= str[j];
            str[j]   ^= str[i];
            str[i++] ^= str[j--];
        }
        return str;
    }
};






















