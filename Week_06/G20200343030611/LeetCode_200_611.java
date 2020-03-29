package datast.unionFInd;

public class LeetCode_200_611 {

    class Solution {

        private int[] dx = {-1, 1, 0, 0};

        private int[] dy = {0, 0, -1, 1};

        public int numIslands(char[][] grid) {
            int m = grid.length;
            if (m == 0) return 0;
            int n = grid[0].length;
            // 构建并查集
            UnionFind unionFind = new UnionFind(grid);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {

                        for (int k = 0; k < 4; k++) {
                            if (i + dx[k] >= 0 && j + dy[k] >= 0 && i + dx[k] < m
                                    && j + dy[k] < n && grid[i + dx[k]][j + dy[k]] == '1')
                                unionFind.union(i * n + j, (i + dx[k]) * n + j + dy[k]);
                        }
                    }
                }
            }
            return unionFind.count;
        }

        class UnionFind {
            private int count = 0;
            private int[] parent;

            public UnionFind(char[][] grid) {
                int m = grid.length;
                int n = grid[0].length;
                parent = new int[m * n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] == '1') {
                            parent[i * n + j] = i * n + j;
                            count++;
                        }
                    }
                }
            }

            public int find(int p) {
                while (p != parent[p]) {
                    parent[p] = parent[parent[p]];
                    p = parent[p];
                }
                return p;
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) return;
                parent[rootP] = rootQ;
                count--;
            }
        }
    }
}
