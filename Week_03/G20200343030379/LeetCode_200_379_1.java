package G20200343030379;





import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * 200. 岛屿数量
 *
 * 给定一个由?'1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出:?1
 * 示例?2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  优秀题解（最全，各种迭代优化算法）：
 *
 *  这两个类似
 */



public class LeetCode_200_379_1 {
    public static void main(String[] args) {
        /**
         * "hit"
         * "cog"
         * ["hot","dot","dog","lot","log","cog"]
         */
//        new LeetCode_200_379().findLadders("hit","cog",Arrays.asList("hot","dot","dog","lot","log","cog"));
    }

    /***
     * BSF 递归法
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 93.24% 的用户
     * 内存消耗 : 42.2 MB , 在所有 Java 提交中击败了 5.23% 的用户
     *
     * 参考题解：https://leetcode.com/problems/number-of-islands/discuss/56359/Very-concise-Java-AC-solution
     * @param grid
     */
    public int numIslands(char[][] grid) {
        // '1'（陆地）和 '0'（水）
        int count=0;
        //行
        int n=grid.length;
        if(n==0) return 0;
        int m=grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //陆地的时候才递归
                if(grid[i][j]=='1'){
                    dfs(grid,i,j,n,m);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 递归的作用主要把陆地变为水，防止重复遍历
     * @param grid
     * @param i 行
     * @param j 列
     * @param n 总行
     * @param m 总列
     */
    private void dfs(char[][] grid, int i, int j, int n, int m) {
        //校验非法值,如果是水也跳过处理
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]=='0') return;

        //把陆地处理为水，防止重复遍历
        grid[i][j]='0';
        dfs(grid,i-1,j,n,m);
        dfs(grid,i+1,j,n,m);
        dfs(grid,i,j-1,n,m);
        dfs(grid,i,j+1,n,m);
    }





}
