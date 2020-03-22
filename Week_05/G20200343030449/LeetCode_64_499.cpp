class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        if (grid.size()==0) return 0;

        int minPathSumArray[grid.size()][grid[0].size()] = {0};

        //init the dynamic array
        minPathSumArray[grid.size()-1][grid[0].size()-1] = grid[grid.size()-1][grid[0].size()-1];

        for (int i = grid.size()-2; i>=0; i--) {
            minPathSumArray[i][grid[0].size()-1] = grid[i][grid[0].size()-1]+minPathSumArray[i+1][grid[0].size()-1];
        }

        for (int i = grid[0].size()-2; i>=0; i--) {
            minPathSumArray[grid.size()-1][i] = grid[grid.size()-1][i]+minPathSumArray[grid.size()-1][i+1];
        }

        for (int i = grid.size()-2; i>=0; i--) {
            for (int j = grid[0].size()-2; j>=0; j--) {
                minPathSumArray[i][j] = min(minPathSumArray[i+1][j],minPathSumArray[i][j+1])+grid[i][j];
            }
        }

        return minPathSumArray[0][0];
    }
};
