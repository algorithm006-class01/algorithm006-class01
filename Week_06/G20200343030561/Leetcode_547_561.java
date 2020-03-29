import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 */

// @lc code=start
// @date Mar 22 2020
// @solution disjoint-set best
class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int len = M.length;
        UnionFind uf = new UnionFind(len);
        for (int i = 0; i < len; i ++) {
            for (int j = 0; j < len; j ++) {
                if (M[i][j] == 1)
                    uf.union(i, j);
            }
        }
        return uf.count;
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
            int rp = find(p);
            int rq = find(q);
            if (rp == rq) return;
            parent[rp] = rq;
            count --;
        }
    }
}
// @lc code=end

