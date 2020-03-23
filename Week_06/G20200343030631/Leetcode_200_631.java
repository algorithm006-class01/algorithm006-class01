package com.dsx.twohundred.zero.zero;

/**
 * 解题思路: 并查集方式，构建并查集，连接所有连通点，最后查看有多少个区域
 * 时间复杂度: O(mn)
 * 空间复杂度: O(mn)，构建并查集需要的
 * 执行用时: 166 ms, 在所有 Java 提交中击败了5.11%的用户
 * 内存消耗: 43.5 MB, 在所有 Java 提交中击败了5.02%的用户
 *
 * @Author: loe881@163.com
 * @Date: 2020/3/19
 */
public class Solution {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        // 边界条件
        if (null == grid || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rowCount = grid.length;
        int colCount = grid[0].length;
        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                System.out.println("row: " + i + ", col: " + j + ", count: " +  unionFind.count);
                if (grid[i][j] == '1') {
                    // 已访问的岛屿，沉没，避免回环计算
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        unionFind.union(i * colCount + j, (i - 1) * colCount + j);
                    }
                    if (i + 1 < rowCount && grid[i + 1][j] == '1') {
                        unionFind.union(i * colCount + j, (i + 1) * colCount + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        unionFind.union(i * colCount + j, i * colCount + j - 1);
                    }
                    if (j + 1 < colCount && grid[i][j + 1] == '1') {
                        unionFind.union(i * colCount + j, i * colCount + j + 1);
                    }
                }
            }
        }
        return unionFind.count;
    }

    static class UnionFind {
        private int count = 0;
        private int[] parents;
        // 权重数组，用于减小生成的并查集树高
        private int[] weights;

        public UnionFind(char[][] grid) {
            this.count = 0;
            int rowCount = grid.length;
            int colCount = grid[0].length;
            this.parents = new int[rowCount * colCount];
            this.weights = new int[rowCount * colCount];
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    if (grid[i][j] == '1') {
                        parents[i * colCount + j] = i * colCount + j;
                        count++;
                    }
                    //  初始权重均为0
                    weights[i * colCount + j] = 0;
                }
            }
        }

        public int find(int p) {
            while (p != parents[p]) {
                parents[p] = parents[parents[p]];
                p = parents[p];
            }
            return p;
        }

        public void union(int dx, int dy) {
            int rootOfDx = find(dx);
            int rootOfDy = find(dy);
            if (rootOfDx != rootOfDy) {
                if (weights[rootOfDx] > weights[rootOfDy]) {
                    parents[rootOfDy] = rootOfDx;
                    weights[rootOfDx] += weights[rootOfDy];
                } else {
                    parents[rootOfDx] = rootOfDy;
                    weights[rootOfDy] += weights[rootOfDx];
                }
                count--;
            }
        }
    }
}
