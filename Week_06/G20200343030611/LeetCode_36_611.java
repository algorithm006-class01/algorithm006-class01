package datast.prune;

import java.util.HashMap;

public class LeetCode_36_611 {

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            HashMap<Character, Integer>[] row = new HashMap[9];
            HashMap<Character, Integer>[] col = new HashMap[9];
            HashMap<Character, Integer>[] piece = new HashMap[9];
            for (int i = 0; i < 9; i++) {
                row[i] = new HashMap<Character, Integer>();
                col[i] = new HashMap<Character, Integer>();
                piece[i] = new HashMap<Character, Integer>();
            }

            int m = board.length;
            int n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char c = board[i][j];
                    if (c != '.') {
                        int index = (i / 3) * 3 + j / 3;
                        row[i].put(c, row[i].getOrDefault(c, 0) + 1);
                        col[j].put(c, col[j].getOrDefault(c, 0) + 1);
                        piece[index].put(c, piece[index].getOrDefault(c, 0) + 1);
                        if (row[i].get(c) > 1 || col[j].get(c) > 1
                                || piece[index].get(c) > 1)
                            return false;
                    }
                }
            }
            return true;
        }
    }
}
