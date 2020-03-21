package G20200343030379;

import java.lang.annotation.ElementType;

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



public class LeetCode_25_379 {
    public static void main(String[] args) {
        char[][] ch={{'1','1'},{'1','1'},{'1','0'}};
//        char[][] ch={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    }


    /**
     * 缺点：复杂度太高了
     * 题解：https://leetcode.com/problems/sudoku-solver/discuss/15752/Straight-Forward-Java-Solution-Using-Backtracking
     *
     * 执行用时 : 21 ms , 在所有 Java 提交中击败了 16.69% 的用户
     * 内存消耗 : 36.7 MB , 在所有 Java 提交中击败了 22.68% 的用户
     * @param board
     */
    public void solveSudoku(char[][] board) {
        if(board.length==0) return;
        dfs(board);
    }

    public boolean dfs(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]=='.'){
                    for(char c='1';c<='9'; c++){
                        if(isValid(board,i,j,c)){
                            if(c=='9') System.out.println("========");
                            board[i][j]=c;

                            //進入下一层
                            if(dfs(board)){
                                return true;
                            }else{
                                //出现失败回退
                                board[i][j]='.';
                                //不能退出，可以迭代下一个数字
                                //return false;
                            }
                        }else{
                            //不能退出，可以迭代下一个数字
                            //return false;
                        }
                    }
                    //10个数字遍历结束都没有匹配上，则回退
                    return false;
                }else{
                    //dfs(board);
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board,int row, int col, char c) {
        int m = board[0].length;
        for (int index = 0; index < m; index++) {
            //检查相同行
            if(board[row][index]==c){

                return false;
            }

            //检查相同列
            if(board[index][col]==c){
                return false;
            }

            //同一个表格
            int xRow=(row / 3 * 3 + index / 3 );
            int yRow=(col / 3 * 3 + index % 3 );

            if(board[xRow][yRow]==c){
                return false;
            }
        }
        return true;
    }
}
