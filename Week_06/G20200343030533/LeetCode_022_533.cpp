#include <string.h>
#include <vector>
#include <iostream>
#include <climits>
#include <algorithm>
using namespace std;

class Solution {
    vector<string> ans;
public:
    vector<string> generateParenthesis(int n) {
        string s = "";
        DFS(s, 0, 0, n);
        return ans;
        
    }

    void DFS(string s, int left, int right, int n){
        if (left == n && right == n){
            ans.push_back(s);
        }
        if ( left < n){
            s.push_back('(');
            DFS(s, left + 1, right, n);
            s.pop_back();
        }
        if ( right < left){
            s.push_back(')');
            DFS(s, left, right+1 ,n );
            s.pop_back();
        }
        return ;
    }
};

int main(int argc, char *argv[]){
    return 0;
}