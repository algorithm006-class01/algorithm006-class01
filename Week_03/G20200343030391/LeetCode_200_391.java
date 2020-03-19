package G20200343030391;

import java.util.LinkedList;

public class LeetCode_200_391 {

    public static void main(String[] args) {
        LeetCode_200_391 solution = new LeetCode_200_391();
        char[][] grid1 = {
                {'1', '1', '1'},
                {'0', '0', '0'},
                {'1', '1', '1'}};
        int numIslands1 = solution.numIslands_UF(grid1);
        System.out.println(numIslands1);

//        char[][] grid2 = {
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}};
//        int numIslands2 = solution.numIslands_DFS(grid2);
//        System.out.println(numIslands2);
    }

    /**
     * 深度优先
     *
     * @param grid
     * @return
     */
    public int numIslands_DFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int island = 0;
        boolean[][] visited = new boolean[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (!visited[r][c] && grid[r][c] == '1') {
                    island++;
                    dfs(grid, visited, r, c);
                }
            }
        }
        return island;
    }

    /**
     * 查找四个方向关联的陆地
     *
     * @param grid
     * @param visited
     * @param r
     * @param c
     */
    private void dfs(char[][] grid, boolean[][] visited, int r, int c) {
        //标记已访问
        visited[r][c] = true;
        //上
        if (r - 1 >= 0 && grid[r - 1][c] == '1' && !visited[r - 1][c]) {
            dfs(grid, visited, r - 1, c);
        }
        //下
        if (r + 1 < grid.length && grid[r + 1][c] == '1' && !visited[r + 1][c]) {
            dfs(grid, visited, r + 1, c);
        }
        //左
        if (c - 1 >= 0 && grid[r][c - 1] == '1' && !visited[r][c - 1]) {
            dfs(grid, visited, r, c - 1);
        }
        //右
        if (c + 1 < grid[0].length && grid[r][c + 1] == '1' && !visited[r][c + 1]) {
            dfs(grid, visited, r, c + 1);
        }
    }

    /**
     * 广度优先
     *
     * @param grid
     * @return
     */
    public int numIslands_BFS(char[][] grid) {
        //           x-1,y
        //  x,y-1    x,y      x,y+1
        //           x+1,y
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;
        boolean[][] marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果是岛屿中的一个点，并且没有被访问过
                // 从坐标为 (i,j) 的点开始进行广度优先遍历
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    LinkedList<Integer> queue = new LinkedList<>();
                    // 小技巧：把坐标转换为一个数字
                    // 否则，得用一个数组存，在 Python 中，可以使用 tuple 存
                    queue.addLast(i * cols + j);
                    // 注意：这里要标记上已经访问过
                    marked[i][j] = true;
                    while (!queue.isEmpty()) {
                        int cur = queue.removeFirst();
                        int curX = cur / cols;
                        int curY = cur % cols;
                        // 得到 4 个方向的坐标
                        for (int k = 0; k < 4; k++) {
                            int newX = curX + directions[k][0];
                            int newY = curY + directions[k][1];
                            // 如果不越界、没有被访问过、并且还要是陆地，我就继续放入队列，放入队列的同时，要记得标记已经访问过
                            if ((newX >= 0 && newX < rows && newY >= 0 && newY < cols) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                                queue.addLast(newX * cols + newY);
                                // 【特别注意】在放入队列以后，要马上标记成已经访问过，语义也是十分清楚的：反正只要进入了队列，你迟早都会遍历到它
                                // 而不是在出队列的时候再标记
                                // 【特别注意】如果是出队列的时候再标记，会造成很多重复的结点进入队列，造成重复的操作，这句话如果你没有写对地方，代码会严重超时的
                                marked[newX][newY] = true;
                            }
                        }
                    }
                }
            }

        }
        return count;
    }

    /**
     * 并查集
     *
     * @param grid
     * @return
     */
    public int numIslands_UF(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] directions = {{1, 0}, {0, 1}};
        int dummy_node = row * col;
        UF uf = new UF(dummy_node + 1);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < directions.length; k++) {
                        int newX = i + directions[k][0];
                        int newY = j + directions[k][1];
                        if (newX < row && newY < col && grid[newX][newY] == '1') {
                            uf.union(newX * col + newY, i * col + j);
                        }
                    }
                } else {
                    uf.union(i * col + j, dummy_node);
                }
            }
        }
        return uf.count - 1;

    }

    class UF {
        // 连通分量个数
        private int count;
        // 存储一棵树
        private int[] parent;
        // 记录树的“重量”
        private int[] size;

        public UF(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;

            // 小树接到大树下面，较平衡
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        private int find(int x) {
            while (parent[x] != x) {
                // 进行路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public int count() {
            return count;
        }
    }
}
