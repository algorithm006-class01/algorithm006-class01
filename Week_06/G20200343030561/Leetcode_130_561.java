/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
// @date Mar 22 2020
// @solution disjoint-set best
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int rl = board.length, cl = board[0].length;
        UnionFind uf = new UnionFind(rl * cl + 1);
        int O = rl * cl;
        for (int r = 0; r < rl; r ++) {
            for (int c = 0; c < cl; c ++) {
                if (board[r][c] == 'X') continue;
                if (r == 0 || c == 0 || r == rl - 1 || c == cl - 1) {
                    uf.union(r * cl + c, O);
                    continue;
                }
                if (board[r - 1][c] == 'O')
                    uf.union(r * cl + c, (r - 1) * cl + c);
                if (board[r + 1][c] == 'O')
                    uf.union(r * cl + c, (r + 1) * cl + c);
                if (board[r][c - 1] == 'O')
                    uf.union(r * cl + c, r * cl + c - 1);
                if (board[r][c + 1] == 'O')
                    uf.union(r * cl + c, r * cl + c + 1);
            }
        }
        for (int r = 0; r < rl; r ++) {
            for (int c = 0; c < cl; c ++) {
                if (board[r][c] == 'X') continue;
                if (!uf.isConnected(r * cl + c, O)) 
                    board[r][c] = 'X';
            }
        }
    }
    class UnionFind {
        int count = 0;
        int[] parent;
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i ++) {
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
            if (p == q) return;
            int rp = find(p);
            int rq = find(q);
            if (rp == rq) return;
            parent[rp] = rq;
            count --;
        }
        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }
}
// @lc code=end

