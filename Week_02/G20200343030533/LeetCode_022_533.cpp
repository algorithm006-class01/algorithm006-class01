// 22. 括号生成
// https://leetcode-cn.com/problems/generate-parentheses/
public:
    vector <string> strings;
    vector<string> generateParenthesis(int n) {
        _generate(0, 0, n, "");
        return strings;
    }
    void _generate(int left, int right, int n, string s){
        // terminate
        if ( left == n && right == n){
            strings.push_back(s);
        }
        //process logical
        // dirll down
        if (left < n){
            _generate(left+1, right, n, s+"(");
        }
        if (left > right){
            _generate(left, right + 1, n, s+")");
        }

        // reverse
        return ;

    }
};