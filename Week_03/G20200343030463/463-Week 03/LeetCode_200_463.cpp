题目:岛屿数量
dfs
解法:
class Solution {
private:
    void dfs(vector<vector<char>>& grid,int r,int c){
        int nr = grid.size();
        int nc = grid[0].size();
        grid[r][c] = '0';
        
        if(r -1 >= 0 && grid[r-1][c] == '1') dfs(grid,r-1,c);
        if(r+1 < nr && grid[r+1][c] == '1') dfs(grid,r+1,c);
        if(c-1 >= 0 && grid[r][c-1] == '1') dfs(grid,r,c-1);
        if(c+1 < nc && grid[r][c+1] == '1') dfs(grid,r,c+1);
    }
    
public:
    int numIslands(vector<vector<char>>& grid) {
        int nr = grid.size();
        if (!nr) return 0;
        int nc = grid[0].size();
        int num_islands = 0;
        for(int r =0; r < nr; ++r){
            for(int c =0; c < nc;++c){
                if(grid[r][c]=='1'){
                    ++num_islands;
                    dfs(grid,r,c);
                }
            }
        }
        return num_islands;
    }
};

国际站提供的解法就是(洪水填充)

https://leetcode.com/problems/number-of-islands/discuss/343513/C%2B%2B-Flood-Fill-faster-than-100

class Solution {
public:
    
    int dx[4] = {-1,0,1,0   };
    int dy[4] = {0,1,0,-1   };
    bool valid(int i,int j,int r,int c){
        return i>=0 && i<r && j>=0 && j<c;
    }
    
    void floodFill(int i,int j,vector<vector<char>>& grid)
    {
        if(grid[i][j] == '.')
            return;
        else
            grid[i][j] = '.';
        
        for(int k=0;k<4;k++)
        {
            int r = i+dx[k];
            int c = j+dy[k];
            if(valid(r,c,grid.size(),grid[0].size()) && grid[r][c]=='1'){
                floodFill(r,c,grid);
            }
        }
    }
    int numIslands(vector<vector<char>>& grid) {
        ios::sync_with_stdio(false);
        cin.tie(NULL);
        
        int connected = 0;
        for(int i=0;i<grid.size();i++){
            
            for(int j=0;j<grid[0].size();j++)
            {
                if(grid[i][j] == '1')
                {
                    floodFill(i,j,grid);
                    connected++;
                }
            }
        }
        return connected;
        
    }
};
