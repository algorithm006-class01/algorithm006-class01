package G20200343030379;

import java.util.ArrayList;
import java.util.List;

/**
 * 52. N皇后 II
 * n?皇后问题研究的是如何将 n?个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 * ?[".Q..", ?// 解法 1
 * ? "...Q",
 * ? "Q...",
 * ? "..Q."],
 *
 * ?["..Q.", ?// 解法 2
 * ? "Q...",
 * ? "...Q",
 * ? ".Q.."]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 参考优秀题解：
 * https://blog.csdn.net/u011433274/article/details/52487752
 * https://github.com/1yx/leetcode.org/blob/master/solutions/51.n%E7%9A%87%E5%90%8E.java
 */
public class LeetCode_52_379 {

    public static void main(String[] args) {
        int count = Integer.highestOneBit(12);
        System.out.println(count);
        Integer.bitCount(12);
    }

    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 36.2 MB , 在所有 Java 提交中击败了 5.35% 的用户
     *
     * 参考优秀题解：
     * https://blog.csdn.net/u011433274/article/details/52487752
     * https://github.com/1yx/leetcode.org/blob/master/solutions/51.n%E7%9A%87%E5%90%8E.java
     * @param n
     * @return
     */
    int count=0;
    public int totalNQueens(int n) {
        if(n==0) return 0;

        char[][] board=new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]='.';
            }
        }

        dfs(n,board,0,0,0,0);
        return count;

    }

    private void dfs(int n, char[][] board, int row, int col, int ll, int lr) {
        if(n==row) {
            count++;
            return;
        }

        int bit=(~(col|ll|lr) & (1 << n)-1);

        while (bit!=0){
            int q=bit & (-bit); //清0最低位

            int colx=log2(q);
            board[row][colx]='Q';

            dfs(n,board,row+1,col|q , (ll|q)<<1 , (lr|q) >>1);

            bit =bit & (bit-1);
            board[row][colx]='.';

        }
    }

    private int log2(int q) {
        return (int) (Math.log(q)/Math.log(2));
    }



}