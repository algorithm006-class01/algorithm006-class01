class Solution {
public:
    // 深度优先搜索
    // 时间复杂度：O(mn)
    // 空间复杂度：O(1)
    // 参考：https://leetcode.com/problems/number-of-islands/discuss/56589/C%2B%2B-BFSDFS
    int numIslands(vector<vector<char>>& grid) {
        int m = grid.size(), n = m ? grid[0].size() : 0, islands = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    removeIsland(grid, i, j, m, n);
                    islands++;
                }
            }
        }

        return islands; 
    }

    void removeIsland(vector<vector<char>>& grid, int m, int n, int rows, int cols){
        if(m < 0 || m == rows || n < 0 || n == cols || grid[m][n] == '0'){
            return;
        }
        grid[m][n] = '0';  // 把原数组的1都删除
        // 分别遍历四个方向
        removeIsland(grid, m-1, n, rows, cols);
        removeIsland(grid, m, n-1, rows, cols);
        removeIsland(grid, m+1, n, rows, cols);
        removeIsland(grid, m, n+1, rows, cols);
    }

    // 广度优先搜索
    // 时间复杂度：O(mn)
    // 空间复杂度：O(mn)
    // 参考：https://leetcode-cn.com/problems/number-of-islands/solution/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/
    int numIslands(vector<vector<char>>& grid) {
        int rows = grid.size(), cols = rows ? grid[0].size() :0 , islands = 0;
        if(rows == 0){
            return 0;
        }
        int directions[4][2] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        vector<vector<bool>> marked(rows, vector<bool>(cols, false));
        queue<int> q; 

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(!marked[i][j] && grid[i][j] == '1'){
                    islands++;
                    q.push(i * cols + j);  // 将当前元素的坐标存入队列
                    marked[i][j] = true;

                    while(!q.empty()){
                        int curP = q.front();
                        q.pop();
                        int curX = curP / cols;
                        int curY = curP % cols;

                        // 遍历四个方向
                        for(int k = 0; k < 4; k++){
                            int newX = curX + directions[k][0];
                            int newY = curY + directions[k][1];
                            if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && 
                                grid[newX][newY] == '1' && !marked[newX][newY]){
                                marked[newX][newY] = true;
                                q.push(newX * cols + newY);
                            }
                        }
                    }
                }
            }
        }

        return islands;
    }

    // 并查集
    // 时间复杂度：
    // 空间复杂度：
    int numIslands(vector<vector<char>>& grid) {
        
    }
};
