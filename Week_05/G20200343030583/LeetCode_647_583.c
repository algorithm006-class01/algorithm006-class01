/*
 * @lc app=leetcode id=647 lang=c
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
#include<stdio.h>

int countSubstrings(char * s){
    int N = strlen(s);
    if(N == 0){
        return 0;
    }
    int i,left,right,ans = 0;
    // expand from center and there are 2*N -1 centers
    for(i = 0;i < N;i++){
        ans += expand_palindromic(s,i,i);
        ans += expand_palindromic(s,i,i+1);
    }
    return ans;
}

int expand_palindromic(char* s,int left,int right){
    int count = 0;
    int N = strlen(s);
    while(left >= 0 && right < N && s[left] == s[right]){
        count++;
        left--;
        right++;
    }
    return count;
}


// @lc code=end

