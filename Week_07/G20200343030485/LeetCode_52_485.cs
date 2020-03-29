public class Solution {
    int result;

    public int TotalNQueens(int n) {
        Dfs(n, 0, 0, 0, 0);
        return result;
    }

    public void Dfs(int n, int row, int col, int ld, int rd) {
        if (row >= n) {
            result++;
            return;
        }

        int bits = ~(col | ld | rd) & ((1 << n) - 1);
        while (bits > 0) {
            int pick = bits & -bits;
            Dfs(n, row + 1, col | pick, (ld | pick) << 1, (rd | pick) >> 1);
            bits &= bits - 1;
        }
    }
}