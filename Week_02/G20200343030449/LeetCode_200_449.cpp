class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        auto numIslands = 0;

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[i].size(); j++) {
                if (grid[i][j]=='0') {
                    continue;
                }
                numIslands++;
                sinkIsland(i,j,grid);
            }
        }

        return numIslands;
    }

    void sinkIsland(int x, int y, vector<vector<char>>& grid) {
        vector<int> dx = {-1,0,0,1};
        vector<int> dy = {0,-1,1,0};

        grid[x][y] = '0';

        for(int i = 0; i < dx.size(); i++) {
            int xNeighbor = x + dx[i];
            int yNeighbor = y + dy[i];

            if (xNeighbor>=0&&xNeighbor<grid.size()&&yNeighbor>=0&&yNeighbor<grid[0].size()) {
                if (grid[xNeighbor][yNeighbor]=='1') {
                    sinkIsland(xNeighbor, yNeighbor, grid);
                }
            }
        }

        return;
    }
};
