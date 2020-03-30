package G20200343030379;

import java.util.ArrayList;
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
public class LeetCode_51_379_4 {


    public static void main(String[] args) throws InterruptedException {
        String s = "000010001".replaceAll("[\\s|0]", ".");
        String.format("%"+String.valueOf(2)+"s","2312");

        long start=System.currentTimeMillis();
        new LeetCode_51_379_4().solveNQueens(1);

        /*for (int i = 0; i < 1000*1000; i++) {
            Integer.toBinaryString(100);
        }*/
        System.out.println(new LeetCode_51_379_4().log2(8));

        long end =System.currentTimeMillis();


        System.out.println(end-start);
    }

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

        dfs(n,res,board,0,0,0,0);

        return res;
    }


    /**
     *
     * @param n  个数
     * @param board
     * @param r  row
     * @param c  col
     * @param lr lright
     * @param ll llfet
     */
    private void dfs(int n,List<List<String>> res,char[][] board,
                     int r, int c, int lr, int ll) {

        if(r==n){
            res.add(constans(board));
            return;
        }

        int bit = (~(c | lr | ll)) & ((1<<n) - 1);
        while (bit !=0){
            //获取最低位
            int q=bit & (-bit);
            /*
            太耗时，不能用这个获取二进制中1是第几位
            String s = Integer.toBinaryString(q);
            int col=s.length()-s.indexOf('1');*/

            int col= (int) log2(q);
            // %ns,q的二进制
            board[r][col] = 'Q';

            dfs(n,res,board,r+1 , c|q ,(lr | q)>>1,(ll | q)<<1);
            board[r][col] = '.';
            bit = bit & (bit-1); //也可以写成 bit -= p;
        }

    }


    private List<String> constans(char[][] board) {
        List<String> res=new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            String sb=new String(board[row]);
            res.add(sb);


        }
        return res;
    }



    //比如二进制  1000 十进制8 ，求第四位，2^3=8;
    //参考资料
    public double log2(double N) {
        return Math.log(N)/Math.log(2);//Math.log的底为e
    }

}