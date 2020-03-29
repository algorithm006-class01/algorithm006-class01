package com.dsx.hundred.thirty.zero;

import java.util.Arrays;

/**
 * 解题思路: 构建并查集，对union进行处理，提高边界元素的权重，当一方的parent为边界元素时，讲另一方的parent指向边界元素
 * 时间复杂度: O(mn)
 * 空间复杂度: O(mn)
 * 执行用时: 18 ms, 在所有 Java 提交中击败了7.33%的用户
 * 内存消耗: 42.1 MB, 在所有 Java 提交中击败了38.50%的用户
 *
 * @Author: loe881@163.com
 * @Date: 2020/3/22
 */
public class Solution {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'O','X','O','O','X','X'},
                {'O','X','X','X','O','X'},
                {'X','O','O','X','O','O'},
                {'X','O','X','X','X','X'},
                {'O','O','X','O','X','X'},
                {'X','X','O','O','O','O'}
        };
        solve(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static void solve(char[][] board) {
        // 边界条件
        if (null == board || board.length == 0 || board[0].length == 0) {
            return;
        }

        int rowCount = board.length;
        int colCount = board[0].length;
        UnionFind unionFind = new UnionFind(rowCount, colCount);
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                if (board[row][col] == 'O'){
                    // 和上下左右合并成一个连通区域.
                    if (row > 0 && board[row - 1][col] == 'O') {
                        unionFind.union(row * colCount + col, (row - 1) * colCount + col);
                    }
                    if (row < rowCount - 1 && board[row + 1][col] == 'O') {
                        unionFind.union(row * colCount + col, (row + 1) * colCount + col);
                    }
                    if (col > 0 && board[row][col - 1] == 'O') {
                        unionFind.union(row * colCount + col, row * colCount + (col - 1));
                    }
                    if (col < colCount - 1 && board[row][col + 1] == 'O') {
                        unionFind.union(row * colCount + col, row * colCount + (col + 1));
                    }
                }
            }
        }

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                if (board[row][col] == 'O'){
                    int currentParent = unionFind.find(row * colCount + col);
                    int currentParentDx = currentParent / colCount;
                    int currentParentDy = currentParent % colCount;
                    boolean isCurrentParentOnEdge =  currentParentDx == 0 || currentParentDx == rowCount - 1
                            || currentParentDy == 0 || currentParentDy == colCount - 1;
                    if (!isCurrentParentOnEdge){
                        board[row][col] = 'X';
                    }
                }
            }
        }

    }

    static class UnionFind {
        private int count = 0;
        private int[] parents;
        private int row;
        private int col;

        public UnionFind(int row, int col) {
            this.row = row;
            this.col = col;
            this.count = row * col;
            this.parents = new int[row * col];
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
            // 修改parent时进行处理
            if (judegeParenet(rootOfP, rootOfQ)) {
                parents[rootOfP] = rootOfQ;
            } else {
                parents[rootOfQ] = rootOfP;
            }
            count--;
        }

        /**
         * 判断两个元素谁更接近边界，如果行 列任一个在边界，优先级最高，否则以坐标绝对值差相比较
         * @param p 元素1
         * @param q 元素2
         * @return q是否比q更接近边界
         */
        private boolean judegeParenet(int p, int q) {
            int dxOfP = p / col;
            int dyOfP = p % col;
            int dxOfQ = q / col;
            int dyOfQ = q % col;
            if (dxOfQ == 0 || dxOfQ == row - 1
                    || dyOfQ == 0 || dyOfQ == col - 1) {
                return true;
            }else if (dxOfP == 0 || dxOfP == row - 1
                    || dyOfP == 0 || dyOfP == col - 1) {
                return false;
            }else {
                return (dxOfP + dyOfP) > (dxOfQ + dyOfQ);
            }
        }
    }
}
