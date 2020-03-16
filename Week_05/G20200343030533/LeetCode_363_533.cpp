#include <string.h>
#include <vector>
#include <iostream>
#include <climits>
#include <algorithm>
#include <set>
#include <unordered_set>
#include <time.h>
using namespace std;


//暴力做法, 穷举所有情况
class Solution1 {
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {

        int rows = matrix.size();
        int cols = matrix[0].size();

        int res = -INT_MAX;

        for (int i = 0 ; i < rows; i++){
            for (int j = i ; j < rows; j++){
                for (int m = 0; m < cols; m++){
                    for (int n = m;  n < cols; n++){
                        int total = calcSums(matrix, i, j, m, n);
                        if ( total == k) return k;
                        if ( total < k) res = max(res, total);

                    }

                }
            }
        }
        return res;

    }
    int calcSums(vector<vector<int>>& matrix, int i, int j, int m, int n){
        int total = 0;
        for (int rs = i; rs <= j; rs++){
            for (int cs = m; cs <= n; cs++){
                total += matrix[rs][cs];
            }
        }
        return total;

    }
};

/*
每次都需要重复计算, 采用DP方法
影响结果的有4个变量，行起始，行结束，列起始，列结束
DP[i][j[m][n], 表示从i..j, m..n的和
DP[0][2][0][2], 表示从0-2行,0-2列区域的合

状态转移
if i == j && m == n:  //即固定行固定列
    DP[i][j][m][n] = matrix[i][m]
else if i == j && m != n:  //固定行， 向下移动列
    DP[i][j][m][n] = DP[i][j][m][n-1] + matrix[i][n]
else if i!=j && m == n: //固定列,  向右移动行
    DP[i][j][m][n] = DP[i][j-1][m][n] + matrix[j][m]
else: //沿对角线往下移动
    DP[i][j][m][n] = DP[i][j-1][m][n] + DP[i][j][m][n-1] - DP[i][j-1][m][n-1] + matrix[j][n];

*/

//还是超时
class Solution2 {
public:

    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {

        int rows = matrix.size();
        if (rows == 0 ) return 0;
        int cols = matrix[0].size();
        if (cols == 0 ) return 0;
        
        // 状态数组
        //int DP[rows][rows][cols][cols]; // stack-overflow, 爆栈了
        // 在heap上分配

        vector < vector < vector<vector<int>> > > DP(rows, vector<vector<vector<int>>>( rows, vector<vector<int>> (cols, vector<int>(cols, 0) ) ) );

        int res = INT_MIN;
        for (int i = 0 ; i < rows; i++){
            for (int j = i ; j < rows; j++){
                for (int m = 0; m < cols; m++){
                    for (int n = m;  n < cols; n++){
                        if (i == j && m == n){
                            DP[i][j][m][n] = matrix[i][m];
                        } else if ( i == j && m != n){
                            DP[i][j][m][n] = DP[i][j][m][n-1] + matrix[i][n];
                        } else if ( i != j && m == n){
                            DP[i][j][m][n] = DP[i][j-1][m][n] + matrix[j][m];
                        } else {
                            DP[i][j][m][n] = DP[i][j-1][m][n] + DP[i][j][m][n-1] - DP[i][j-1][m][n-1] + matrix[j][n];
                        }
                        if (DP[i][j][m][n] == k) return k;
                        if (DP[i][j][m][n] < k) {
                            res = max(DP[i][j][m][n], res);
                        }
                    }
                }
            }
        }
        return res;

    }

};

/*
为了降低维度， 我们重新定义状态
DP[i][j]: 从0..i, 0..j的和

DP[i][j] = DP[i-1][j] + DP[i][j-1] - DP[i-1][j-1] + matrix[i][j]

对于任意的 i1..i2, j1..j2的状态，我们都有

DP[i1..i2][j1..j2] = DP[i2][j2] - DP[i2][j1] - DP[i1][j2]  + DP[i1][j1];
*/

class Solution {
public:

    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {

        int rows = matrix.size();
        if (rows == 0 ) return 0;
        int cols = matrix[0].size();
        if (cols == 0 ) return 0;

        int res = -INT_MAX;
        int DP[rows+1][cols+1];
        for (int i = 0; i < rows + 1; i++){
            DP[i][0] = 0;
        }
        for (int j = 0; j < cols + 1; j++){
            DP[0][j] = 0;
        }
        for (int i = 1 ; i < rows + 1; i++){
            for (int j = 1 ; j < cols + 1; j++){
                DP[i][j] = DP[i-1][j] + DP[i][j-1] - DP[i-1][j-1] + matrix[i-1][j-1];
                //printf("%d-%d:%d\n", i, j, DP[i][j]);
            }
        }
        for (int i1 = 0 ; i1 < rows; i1++){
            for (int i2 = i1+1 ; i2 <= rows; i2++){
                for (int j1 = 0; j1 < cols; j1++){
                    for (int j2 = j1+1;  j2 <= cols; j2++){
                        int total =  DP[i2][j2] - DP[i2][j1] - DP[i1][j2]  + DP[i1][j1];
                        //printf("%d.%d.%d.%d: %d\n",i1,i2,j1,j2,total);
                        if (total == k) return total;
                        if ( total <k ) res = max(total,res);
                    }
                }
            }
        }
        return res;

    }

};



int main(int argc, char const *argv[])
{
    vector<vector<int>> matrix{{2,2,-1},{2,1,3}};

    Solution sol;
    clock_t t;
    t = clock();
    cout << sol.maxSumSubmatrix(matrix, 0) << endl ;
    t = clock() - t;
    cout << "time: " << ((float)t)/CLOCKS_PER_SEC << endl;
    return 0;
}
