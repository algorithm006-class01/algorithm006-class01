学习笔记

class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        
        helper(res,"",n,n);
        
        return res;
    }
    
    void helper( vector<string>&ret,string str,int left,int right){
        if(left == 0 && right ==0){
            ret.push_back(str);
            return;
        }
        
        if(left > 0) helper(ret,str+"(",left-1,right);
        if(right > left) helper(ret,str+")",left,right-1);
    }
};
