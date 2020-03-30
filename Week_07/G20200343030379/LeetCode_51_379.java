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
 */
public class LeetCode_51_379 {

    public static void main(String[] args) {
        //十进制转二进制
        //String s = Integer.toBinaryString(-2147483648);
    }

    /**
     * 执行用时 : 3 ms , 在所有 Java 提交中击败了 90.02% 的用户
     * 内存消耗 : 41.3 MB , 在所有 Java 提交中击败了 8.20% 的用户
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
        dfs(board,res,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),0);
        return res;
    }

    private void dfs(char[][] board, List<List<String>> res
         , List<Integer> colList
            ,List<Integer> na
            ,List<Integer> pie, int row) {
        int n = board.length;
        //退出条件
        if(row==n){
            res.add(constans(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if(na.contains(row+col)) continue;
            if(pie.contains(row-col)) continue;
            if(colList.contains(col)) continue;

            //选择
            board[row][col]='Q';
            colList.add(col);
            na.add(row+col);
            pie.add(row-col);

            //递归
            dfs(board,res,colList,na,pie,row+1);

            //撤销
            board[row][col]='.';
            colList.remove(row);
            na.remove(row);
            pie.remove(row);
        }
    }

    private boolean validate(char[][] board,int row,int col) {
        //检查当列
        for (int i = 0; i < row; i++) {
            if(board[i][col]=='Q'){
                return false;
            }
        }

        //检查左上角
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //检查右上角
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    private List<String> constans(char[][] board) {
        List<String> res=new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            String sb=new String(board[row]);
            res.add(sb);
        }
        return res;
    }

    /*
    时间复杂度多，不建议使用
    private List<String> constans(char[][] board) {
        List<String> res=new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            StringBuilder sb=new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                sb.append(board[row][j]);
            }
            res.add(sb.toString());
        }
        return res;
    }*/
}