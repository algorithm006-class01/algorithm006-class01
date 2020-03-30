package G20200343030379;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * 参考优秀题解：
 * https://blog.csdn.net/u011433274/article/details/52487752
 * https://github.com/1yx/leetcode.org/blob/master/solutions/51.n%E7%9A%87%E5%90%8E.java
 */
public class LeetCode_51_379_5 {



    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 41.1 MB , 在所有 Java 提交中击败了 9.07% 的用户
     * @param n
     * @return
     */

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        if(n==0) return res;

        char board[][]=new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]='.';
            }
        }

        dfs(n,board,res,0,0,0,0);

        return res;
    }

    private void dfs(int n,char[][] board, List<List<String>> res, int row, int col, int lr, int ll) {
        if(row==n){
            res.add(convers(board));
            return;
        }

        int bit= (~(col | lr | ll))  & ((1<<n )-1);
        while (bit!=0){
            int q = bit & (-bit);

            int colx = log2(q);
            board[row][colx]='Q';
            //递归
            dfs(n,board,res,row+1,col|q , (lr|q) >> 1,(ll|q) << 1);

            //撤销
            bit = bit & (bit -1);  //也可以写成 bit -= p;
            board[row][colx]='.';
        }

    }

    private int log2(int q) {
        return (int) (Math.log(q)/Math.log(2));//Math.log的底为e
    }

    private List<String> convers(char[][] board) {
        List<String> res=new ArrayList<>();

        /*
           有更高效的遍历方法
        for (char[] chars : board) {
            StringBuilder sb=new StringBuilder();
            for (char aChar : chars) {
                sb.append(aChar);
            }
            res.add(sb.toString());
        }*/

        for (char[] chars : board) {
            String sb=new String(chars);
            res.add(sb);
        }
        return res;
    }


}