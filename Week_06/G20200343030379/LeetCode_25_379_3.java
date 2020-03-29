package G20200343030379;

import java.util.Arrays;

/**
 * 37. 解数独
 *
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字?1-9?在每一行只能出现一次。
 * 数字?1-9?在每一列只能出现一次。
 * 数字?1-9?在每一个以粗实线分隔的?3x3?宫内只能出现一次。
 * 空白格用?'.'?表示。
 *
 *
 *
 * 一个数独。
 *
 *
 *
 * 答案被标成红色。
 *
 * Note:
 *
 * 给定的数独序列只包含数字?1-9?和字符?'.'?。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是?9x9?形式的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */



public class LeetCode_25_379_3 {
    public static void main(String[] args) {
        char[][] ch={{'1','1'},{'1','1'},{'1','0'}};
//        char[][] ch={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    }


    /**
     * 直接递归法 （优化时间复杂度版）
     * 题解：https://leetcode.com/problems/sudoku-solver/discuss/15911/Less-than-30-line-clean-java-solution-using-DFS
     * 优点：枚举并换数字的时候，我们先把出现过的数字查出来了，不用每次换的时候查一次。
     *      比如说1-9，要查10次是否满足，现在1-9 只要查一次即可知道是否存在重复问题。
     * 执行用时 : 9 ms , 在所有 Java 提交中击败了 45.34% 的用户
     * 内存消耗 : 38.4 MB , 在所有 Java 提交中击败了 7.90% 的用户
     * @param board
     */
    public void solveSudoku(char[][] board) {
        if(board.length==0) return;
        dfs(board,0);
    }

    public boolean dfs(char[][] board,int d) {
        int n = board.length;
        int m = board[0].length;
        //判断退出
        if(d==n*m){
            return true;
        }

        int row = d / n;
        int col = d % n;

        if(board[row][col]!='.') {
            return dfs(board, d + 1);
        }else{
            boolean[] validB=new boolean[10];
            //检查出现的数字
            //核心代码
            isValid(board,row,col,validB);
            for (char c = '1'; c <= '9' ; c++){
                if(validB[c-'0']) {
                    //判断是否有效
                    board[row][col] = c;
                    if(dfs(board,d + 1)){
                        return true;
                    }
                    //撤回状态
                    board[row][col] = '.';
                }
            }

            //查询所有都没有则返回失败
            return false;
        }


    }

    public boolean isValid(char[][] board,int row, int col, boolean[] validB) {
        Arrays.fill(validB,true);
        for (int index = 0; index < board.length; index++) {
            //搜索相同行，存在的值
            if(board[row][index]!='.') validB[board[row][index]-'0']=false;

            //搜索相同列，存在的值
            if(board[index][col]!='.') validB[board[index][col]-'0']=false;

            //相同同一个组，存在的值
            int xRow = row / 3 * 3 + index / 3;
            int xCol = col / 3 * 3 + index % 3;
            if(board[xRow][xCol]!='.') validB[board[xRow][xCol]-'0']=false;
        }
        return true;
    }
}
