#include <string.h>
#include <vector>
#include <iostream>
using namespace std;
// 最长公共子串
class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        int m = text1.length();
        int n = text2.length();
        int opt[m+1][n+1];
        for (int i = 0; i < m+1; i++) opt[i][0] = 0;
        for (int j = 0; j < n+1; j++) opt[0][j] = 0;

        for (int i = 1; i < m + 1; i++){
            for (int j = 1; j < n + 1; j++){
                if (text1[i-1] != text2[j-1]){
                    opt[i][j] = max(opt[i-1][j], opt[i][j-1]);
                } else{
                    opt[i][j] = opt[i-1][j-1] + 1;
                }

            }
        }
        return opt[m][n];
        

    }
};

int main(int argc, char *argv[]){
    Solution sol;
    cout << sol.longestCommonSubsequence("abc", "acd") << '\n';
    return 0;
}