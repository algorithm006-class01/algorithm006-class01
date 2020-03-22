/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @solution dfs best
// class Solution {
//     public int numIslands(char[][] grid) {
//         if (grid == null || grid.length == 0) return 0;
//         int nr = grid.length;
//         int nc = grid[0].length;
//         int ni = 0;
//         for (int r = 0; r < nr; r++) {
//             for(int c = 0; c < nc; c++) {
//                 if(grid[r][c] == '1') {
//                     ni ++;
//                     dfs(grid, r, c);
//                 }
//             }
//         }
//         return ni;                                                          
//     }

//     private void dfs(char[][] grid, int r, int c) {
//         int nr = grid.length;
//         int nc = grid[0].length;
//         if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') 
//             return;
        
//         grid[r][c] = '0';
//         dfs(grid, r - 1, c);
//         dfs(grid, r + 1, c);
//         dfs(grid, r, c - 1);
//         dfs(grid, r, c + 1);
//     }
// }

// @lc code=start
// @date Mar 22 2020
// @solution disjoint-set
class Solution {
    public int numIslands(char[][] grid) {
        int rl = grid.length, cl = grid[0].length, waterCount = 0;
        UnionFind uf = new UnionFind(rl * cl);
        for (int r = 0; r < rl; r ++) {
            for (int c = 0; c < cl; c ++) {
                if (grid[r][c] == '1') {
                    if (r > 0 && grid[r - 1][c] == '1')
                        uf.union(r * cl + c, (r - 1) * cl +c);
                    else if (c > 0 && grid[r][c - 1] == '1')
                        uf.union(r * cl + c, r * cl + c - 1);
                } else {
                    waterCount ++;
                }
            }
        }
        return uf.count - waterCount;
    }
    class UnionFind {
        int count = 0;
        int[] parent;
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i ++) 
                parent[i] = i;
        }
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q) {
            if (p == q) return;
            int rp = find(p);
            int rq = find(q);
            if (rp == rq) return;
            parent[rp] = rq;
            count --;
        }
    }
}


// @lc code=end

