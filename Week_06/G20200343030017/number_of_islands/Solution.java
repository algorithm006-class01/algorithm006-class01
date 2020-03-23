package week6.number_of_islands;

public class Solution {
    int[][] directs = {{1, 0}, {0, 1}};

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        Disjoint disjoint = new Disjoint(grid.length * grid[0].length + 1);
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == '0') {
                    disjoint.merge(y * grid[0].length + x, grid.length * grid[0].length);
                }
                if (grid[y][x] == '1') {
                    for (int[] direct : directs) {
                        int newX = x + direct[0];
                        int newY = y + direct[1];
                        if (newX < grid[0].length && newY < grid.length && grid[newY][newX] == '1') {
                            disjoint.merge(y * grid[0].length + x, newY * grid[0].length + newX);
                        }
                    }
                }

            }
        }
        return disjoint.count - 1;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        Solution s = new Solution();
        System.out.println(s.numIslands(grid));
    }
}

