package G20200343030379;

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



public class LeetCode_25_379_2 {
    public static void main(String[] args) {
        char[][] ch={{'1','1'},{'1','1'},{'1','0'}};
//        char[][] ch={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    }


    /**
     * 迭代递归法
     * 缺点：复杂度太高了
     * 题解：https://leetcode.com/problems/sudoku-solver/discuss/15752/Straight-Forward-Java-Solution-Using-Backtracking
     * 缺点：枚举并换数字的时候，每次换的时候isValid()查一次是否非法，太耗时了，其实可以一把查询出来的。
     *      *      比如说1-9，要查10次是否满足。
     *                  实际上1-9 只要查一次即可知道是否存在重复问题（见优化版代码：LeetCode_25_379_3）。
     * 执行用时 : 29 ms , 在所有 Java 提交中击败了 11.19% 的用户
     * 内存消耗 : 36.9 MB , 在所有 Java 提交中击败了 18.99% 的用户
     * @param board
     */
    public void solveSudoku(char[][] board) {
        if(board.length==0) return;
        dfs(board,0,0);
    }

    public boolean dfs(char[][] board,int row ,int col) {
        int n = board.length;
        int m = board[0].length;
        for (int i = row; i < n; i++) {
            for (int j = col; j < m; j++) {
                if(board[i][j]!='.') continue;

                if(board[i][j]=='.'){
                    for(char c='1';c<='9'; c++){
                        if(isValid(board,i,j,c)){
                            board[i][j]=c;

                            //進入下一层
                            if(dfs(board,row,col)){
                                return true;
                            }
                            //出现失败回退
                            board[i][j]='.';
                            //不能退出，可以迭代下一个数字
                            //return false;
                        }
                    }
                    //10个数字遍历结束都没有匹配上，则回退
                    return false;
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
