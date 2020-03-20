package G20200343030391;


import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_1091_391 {

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 0, 0}, {0, 0, 0, 1, 1, 1, 0}, {1, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 0, 1}, {0, 0, 1, 0, 0, 0, 0}};
        int i = new LeetCode_1091_391().shortestPathBinaryMatrix_1(grid);
        System.out.println(i);

    }

    /**
     * BFS
     *
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix_1(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }
        int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {-1, 1}, {1, 0}, {1, 1}};
        int row = grid.length;
        int clo = grid[0].length;
        boolean[][] visited = new boolean[row][clo];
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new int[]{0, 0, 1});
        while (!queue.isEmpty()) {
            for (int j = 0; j < queue.size(); j++) {
                int[] poll = queue.poll();
                int path = poll[2];
                int x = poll[0];
                int y = poll[1];
                if (x == row - 1 && y == clo - 1) {
                    return path;
                }
                for (int i = 0; i < direction.length; i++) {
                    int newX = x + direction[i][0];
                    int newY = y + direction[i][1];
                    if (newX >= 0 & newX < row && newY >= 0 && newY < clo && !visited[newX][newY] && grid[newX][newY] == 0) {
                        queue.add(new int[]{newX, newY, path + 1});
                        visited[newX][newY] = true;
                    }
                }
            }
        }
        return -1;
    }


    /**
     * DP
     *
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix_2(int[][] grid) {
        return -1;
    }

    /**
     * A*
     *
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix_3(int[][] grid) {
        return -1;
    }


}
