//https://leetcode-cn.com/problems/generate-parentheses/
// 因为每次参数s都要往后传的时候都在已有的基础上发生了变化，因此回来的时候，要重置状态。
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        string s;
        DFS(0,0,n, s, res);
        return res;

    }
    void DFS(int left, int right, int n, string& s, vector<string> &res){
        if (left == n && right == n){
            res.push_back(s);
            return ;
        }

        if (left < n){
            s.push_back('(');
            DFS(left+1, right, n, s, res);
            //reverse state
            s.pop_back();
        }
        if (right < left){
            s.push_back(')');
            DFS(left, right+1, n, s, res);
            //reverse state
            s.pop_back();
        }
        
       
    }
};