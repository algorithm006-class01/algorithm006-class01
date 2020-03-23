package com.leetcode.week06;

/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 */


class Solution547_509 {
    public static void main(String[] args) {
        long startTime=System.nanoTime(); //获取开始时间

        Solution547_509 sol = new Solution547_509();
        int[][] M = {{1,1,0},{1,1,0},{0,0,1}};

        System.out.println(sol.findCircleNum(M));

        long endTime=System.nanoTime(); //获取结束时间
        System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
    }

    public int findCircleNum(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        for (int i = 0; i < M.length - 1; i++) {
            for ( int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        for(int i: uf.parent) System.out.println(i);
        return uf.count;
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
            return;
        }
    }

}