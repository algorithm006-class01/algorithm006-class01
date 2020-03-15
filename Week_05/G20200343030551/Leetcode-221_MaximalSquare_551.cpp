#include <vector>
#include <algorithm>
using namespace std;

struct Node
{
    int row_nums;
    int col_nums;
    Node():row_nums(0),col_nums(0){}
};

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if(matrix.empty() || matrix[0].empty() )
            return 0;
        int rows=matrix.size();
        int cols=matrix[0].size();
        vector<vector<Node>> dp(rows+1,vector<Node>(cols+1));
        for(int i=1;i<=rows;i++)
        {
            for(int j=1;j<=cols;j++)
            {
                if(matrix[i-1][j-1]=='1')
                {
                    dp[i][j].row_nums=min(dp[i-1][j].row_nums,dp[i-1][j-1].row_nums)+1;
                    dp[i][j].col_nums=min(dp[i][j-1].col_nums,dp[i-1][j-1].col_nums)+1;
                }
            }
        }

        int max_size=0;
        for(int i=1;i<=rows;i++)
        {
            for (int j = 1; j <= cols; j++)
            {
                int edge=min(dp[i][j].row_nums,dp[i][j].col_nums);
                max_size=max(max_size,edge*edge);
            }
        }
        return max_size;
    }
};

