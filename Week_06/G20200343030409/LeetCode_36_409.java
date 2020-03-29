/*
    time complexity: O(1), space complexity: O(1)

    Method 1 - use string

    use string,  to store
    row, col, box's used value in set
    simple way, but it's so slow... 12ms

 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> used = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    if (!used.add(num + "row" + i) ||
                            !used.add(num + "col" + j) ||
                            !used.add(num + "box" + i/3 + "-" + j/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
/*
    Method 2 - use 3 set
    2ms


    the key is
    char boxVal = board[(i/3)*3 + j/3][(i%3)*3 + j%3];
*/
class Solution2 {
 */
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> box = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                char rowVal = board[i][j];
                if (rowVal != '.' && !row.add(rowVal)) return false;

                char colVal = board[j][i];
                if (colVal != '.' && !col.add(colVal)) return false;

                char boxVal = board[(i/3)*3 + j/3][(i%3)*3 + j%3];
                if (boxVal != '.' && !box.add(boxVal)) return false;

            }
        }
        return true;
    }
}
/*
    Method 3 - use bitwise operator
*/
class Solution3 {
 */
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] box = new int[9];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                int boxIndex = (i/3)*3 + j/3;

                if (num != '.') {
                    idx = 1 << (num - '0'); // 左移（1~9）意思就是用9個位元去存

                    if ((row[i] & idx) > 0 ||
                            (col[j] & idx) > 0 ||
                            (box[boxIndex] & idx) > 0) { //用＆去判斷是否存在
                        return false;
                    }
                    row[i] |= idx; // 紀錄值
                    col[j] |= idx;
                    box[boxIndex] |= idx;
                }

            }
        }
        return true;
    }
}