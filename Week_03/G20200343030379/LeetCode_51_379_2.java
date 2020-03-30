package G20200343030379;



import java.util.ArrayList;
import java.util.List;

/**
 * 优化版
 * 51. N皇后
 *  n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *  上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的?n?皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的?n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 参考优秀题解：
 */
public class LeetCode_51_379_2 {
    public static void main(String[] args) {
       List<List<String>> strings = new LeetCode_51_379_3().solveNQueens(4);
        System.out.println(strings);
       new LeetCode_51_379_2().construct(new char[][]{{'1','2'}});


    }

    /**
     *  执行用时 : 3 ms , 在所有 Java 提交中击败了 90.88% 的用户
     *  内存消耗 : 41.5 MB , 在所有 Java 提交中击败了 5.58% 的用户
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        char[][] board=new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j]='.';
            }
        }
        dfs(res,board,0);
        return res;
    }


    /**
     *
     * @param res       当前初始化完的N皇后结构，每个格子都是“.”
     * @param nStrut    保存最后选择的所有结果
     * @param row       行
     */
    private void dfs(List<List<String>> res,char[][] nStrut,int row) {
        //退出机制
        if(nStrut.length==row){
            res.add(construct(nStrut));
            return ;
        }
        //执行逻辑
        //遍历
        for (int col = 0; col < nStrut.length; col++) {
            //校验非法
            if(!validate(nStrut,row,col)){
                continue;
            }

            //选中
            nStrut[row][col]='Q';
            //递归
            dfs(res,nStrut,row+1);
            //撤回选择
            nStrut[row][col]='.';
        }
    }

    /**
     * 校验当前位置是否可用，不属攻击范围
     * true 可用  false 非可用，会被攻击
     * @param broad 当前选择的结果
     * @param row  行
     * @param col  列
     * @return
     */
    private boolean validate(char[][] broad, int row, int col) {
        //校验所有行的当前列，是否存在皇后  i == col,不能用这里传进来的col，因为是会变的
        //broad.length 其实可以改为 row，因为下面的肯定是空的数据，不可能存在攻击范围
        //for (int i = 0; i < broad.length; i++) {
        for (int i = 0; i < row; i++) {
            if(broad[i][col]=='Q'){
                return false;
            }
        }

        //校验左上角，排除自身 row-- ,col--
        for (int i = row-1,j = col-1; i>=0 && j>=0 ; i--,j--) {
            if(broad[i][j]=='Q'){
                return false;
            }
        }

        //校验右上角，排除自身 row-- , col++
        for (int i = row-1,j = col+1; i>=0 && j<broad.length ; i--,j++) {
            if(broad[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }


    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            list.add(s);
        }
        return list;
    }



}
