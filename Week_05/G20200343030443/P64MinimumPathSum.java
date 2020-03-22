//Java：最小路径和
public class P64MinimumPathSum {
    
    public static void main(String[] args) {
        Solution solution = new P64MinimumPathSum().new Solution();
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        
        public int minPathSum(int[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int row = grid.length - 1, col = grid[0].length - 1, i, j;
            for (i = 0; i <= row; i++) {
                for (j = 0; j <= col; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    if (i == 0) {
                        grid[i][j] += grid[i][j - 1];
                    } else if (j == 0) {
                        grid[i][j] += grid[i - 1][j];
                    } else {
                        grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                    }
                }
            }
            return grid[row][col];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
