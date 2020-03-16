class Solution {
public:
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    int countSubstrings(string s) {
        int n = s.size();
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            palindromic(s, i, i, cnt);  // 偶数
            palindromic(s, i, i+1, cnt);  // 奇数
        }
        return cnt;
    }
    
private:
    void palindromic(string s, int left, int right, int& cnt) {
        while(left >=0 && right < s.size() && s[left] == s[right]) {
            cnt++;
            left--;
            right++;
        }
    }
};