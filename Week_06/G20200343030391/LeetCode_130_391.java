package G20200343030391;

import java.util.Arrays;

public class LeetCode_130_391 {
    public static void main(String[] args) {
        char[][] M = {
                {'O','X','X','O','X'},
                {'X','O','O','X','O'},
                {'X','O','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'}
        };





        new LeetCode_130_391().solve_2(M);
        System.out.println(Arrays.deepToString(M));

    }

    /**
     * 并查集
     *
     * @param board
     */
    public void solve_2(char[][] board) {
        if (board.length <= 1 || board[0].length <= 1) {
            return;
        }
        int row = board.length;
        int clo = board[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int X = row * clo;
        UnionFind unionFind = new UnionFind(X + 2);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < clo; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || j == 0 || i == row - 1 || j == clo - 1) {
                        unionFind.union(i * clo + j, X);
                    } else {
                        for (int k = 0; k < 4; k++) {
                            int newX = i + directions[k][0];
                            int newY = j + directions[k][1];
                            if (board[newX][newY] == 'O') {
                                unionFind.union(newX * clo + newY, i * clo + j);
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < clo; j++) {
                if (unionFind.connected(i * clo + j, X)) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }


    class UnionFind {
        //存储树
        private int[] parent;
        //子树大小
        private int[] size;
        //联通分量
        private int count;

        public UnionFind(int count) {
            parent = new int[count];
            size = new int[count];
            for (int i = 0; i < count; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            this.count = count;
        }

        public int find(int target) {
            while (target != parent[target]) {
                target = parent[target];
                parent[target] = parent[parent[target]];
            }
            return target;
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            if (size[rootP] >= size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = parent[rootQ];
                size[rootQ] += size[rootP];
            }
            count--;
        }

    }
}
