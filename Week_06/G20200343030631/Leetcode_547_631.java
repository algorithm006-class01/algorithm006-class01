package com.dsx.fivehundred.forty.seven;

/**
 * 解题思路: 并查集实现方式
 * 时间复杂度: O(n^3)
 * 空间复杂度: O(n)
 * 执行用时: 5 ms, 在所有 Java 提交中击败了26.45%的用户
 * 内存消耗: 41.7 MB, 在所有 Java 提交中击败了78.93%的用户
 * @Author: loe881@163.com
 * @Date: 2020/3/19
 */
public class Solution {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1,1,0},
                {1,1,1},
                {0,1,1}
        };
        System.out.println(findCircleNum(nums));
    }

    public static int findCircleNum(int[][] M) {
        int length = M.length;
        UnionFind unionFind = new UnionFind(length);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (M[i][j] == 1){
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.count;
    }

    static class UnionFind {
        private int count = 0;
        private int[] parents;

        public UnionFind(int count) {
            this.count = count;
            this.parents = new int[count];
            for (int i = 0; i < count; i++) {
                parents[i] = i;
            }
        }

        public int find(int p) {
            while (p != parents[p]) {
                parents[p] = parents[parents[p]];
                p = parents[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootOfP = find(p);
            int rootOfQ = find(q);
            if (rootOfP == rootOfQ) {
                return;
            }
            parents[rootOfP] = rootOfQ;
            count--;
        }
    }
}
