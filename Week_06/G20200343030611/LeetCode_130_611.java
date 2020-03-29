package datast.unionFInd;

public class LeetCode_130_611 {

    class Solution {

        private int[] dx = {-1, 1, 0, 0};

        private int[] dy = {0, 0, -1, 1};

        public void solve(char[][] board) {
            int m = board.length;
            if (m == 0) return;
            int n = board[0].length;
            UnionFind unionFind = new UnionFind(m * n + 1);
            int dummyNode = m * n;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O') {
                        if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                            unionFind.union(i * n + j, dummyNode);
                        } else {
                            for (int k = 0; k < 4; k++) {
                                if (board[i + dx[k]][j + dy[k]] == 'O') {
                                    unionFind.union(i * n + j, (i + dx[k]) * n + j + dy[k]);
                                }
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (unionFind.find(i * n + j) != unionFind.find(dummyNode))
                        board[i][j] = 'X';
                }
            }

        }

        class UnionFind {
            private int count = 0;
            private int[] parent;

            public UnionFind(int n) {
                count = n;
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
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
