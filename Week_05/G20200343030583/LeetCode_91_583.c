/*
 * @lc app=leetcode id=91 lang=c
 *
 * [91] Decode Ways
 * refer to the stair climbing problem, 
 * the last letter can be formedby 2 digits or 1 digits.
 * should have several cases that need to consider
 * https://leetcode-cn.com/problems/decode-ways/solution/c-0ms-85mb-dong-tai-gui-hua-by-mapleking/
 */
#include<stdio.h>
// #include<stdlib.h>
// @lc code=start
int numDecodings(char * s){
    if(s == NULL) return 0;
    int N = strlen(s);
    if(N == 1){
        if(s[0]=='0'){
            return 0;
        }
        return 1;
    }
    // initilize the first two condition
    int dp[N];
    if (s[0] != '0'){
        dp[0] = 1;
    }
    else{
        dp[0] = 0;
    }
    
    int codeVal = 10 * (s[0] - '0') + (s[1] - '0');
    if(codeVal == 0 || (codeVal>26 && s[1]=='0')){
        dp[1] = 0;
    }
    else if(10 < codeVal && codeVal <= 26 && codeVal != 20){
        dp[1] = 2;
    }
    else dp[1] = dp[0];
    int i;
    for(i = 2;i < N;i++){
        codeVal = 10 * (s[i-1] - '0') + (s[i] - '0');
        if((codeVal == 0) || (codeVal>26 && s[i]=='0')){
            dp[i] = 0;
        }
        else if(codeVal == 10 || codeVal == 20){
            dp[i] = dp[i-2];
        }
        else if(10 < codeVal && codeVal <= 26){
            dp[i] = dp[i-1] + dp[i-2];
        }
        else{
            // for 0<codeVal<=9 and codeVal > 26 && s[i-1]!='0'
            dp[i] = dp[i-1];
        }
        
    }
    return dp[N-1];
}



// @lc code=end

