#include <vector>
#include <string>
#include <iostream>

using namespace std;

/* 和52题一样，只不过需要输出摆放信息
* 所以需要一个额外的数组，存放每一行的摆放位置，
* 还有专门的打印函数来
* 使用位运算，需要从0100中获取1的位置
*/
class Solution {
vector<vector<string>> ans;
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<int> tmp(n, 0);
        if ( n < 1) return ans;
        DFS(n, 0, 0, 0, 0, tmp);
        return ans;

    }

    void DFS(int n, int row, int col, int pie, int na, vector<int>& tmp){
        if ( row == n){
            vector<string> s = generateResult(tmp);
            ans.push_back(s);
            return ;
        }
        
        int bits = ( (~(col|pie|na) ) & ((1<<n) -1) );
        while (bits){
            int pos = (bits & -bits);
            tmp[row] = get_pos(pos);
            bits -= pos;
            DFS(n, row+1, col|pos, (pie|pos)<<1, (na|pos) >> 1, tmp);
        }
        return ;
    }

    vector<string> generateResult( vector<int>& arr){
        vector<string> res;
        for (int i = 0; i < arr.size(); i++){
            string s(arr.size(), '.');
            s[arr[i]] = 'Q';
            res.push_back(s);
        }

        return res;

    }

    int get_pos(int i){
        int pos= 0;
        while ( i ){
            pos++;
            i >>= 1;
        }
        return pos - 1; //第1位的数组下标是0
    }
};

int main(int argc, char *argv[]){
    Solution sol;
    sol.solveNQueens(4);
}