package week6.valid_sudoku;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[10][10];
        boolean[][] cols = new boolean[10][10];
        boolean[][] areas = new boolean[10][10];

        for (int x=0;x<9;x++){
            for (int y=0;y<9;y++){
                if (board[y][x]=='.'){
                    continue;
                }else{
                    int temp = board[y][x]-48;
                    int area = (y / 3) * 3 + x / 3;
                    if (rows[y][temp]||cols[x][temp]||areas[area][temp]){
                        return false;
                    }else{
                        rows[y][temp]=true;
                        cols[x][temp]=true;
                        areas[area][temp]=true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        Solution s = new Solution();
        System.out.println(s.isValidSudoku(board));
    }
}
