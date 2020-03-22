//17. 电话号码的字母组合
//https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
#include<vector>
#include<string>
using namespace std;

//回溯算法，每次选择一个字母，之后回溯。
//本质上排列题目

class Solution {
public:
    vector<string> letterCombinations(string digits) {

        vector<string> m = {
            "",
            "", "abc","def",
            "ghi","jkl","mno",
            "pqrs","tuv","wxyz"
        };

        vector<string> res;
        if (digits.size() == 0) return res;
        string s;
        

        DFS(digits, 0, s, res, m);
        return res;
    }

    void DFS(string digits, int depth, string & s, vector<string> &res, vector<string>& m){
        if (depth == digits.size()){
            res.push_back(s);
            return ;
        }
        //获取对应键盘的字母
        string tmp = m[digits[depth] - '0'];
        for (int i = 0; i < tmp.size(); i++){
            s.push_back(tmp[i]);
            DFS(digits, depth+1, s, res, m);
            s.pop_back();
        }
        return ;
    }
};