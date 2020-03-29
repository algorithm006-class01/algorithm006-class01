package G20200343030015.week_07;

/**
 * Created by majiancheng on 2020/3/29.
 *
 * 52. N皇后 II
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 */
public class LeetCode_52_015 {
    int count = 0;
    int size = 0;
    public int totalNQueens(int n) {
        size = (1 << n) - 1;
        dfs(0, 0, 0);

        return count;
    }

    public void dfs(int row, int master, int slave) {
        if(row == size)  {
            count ++;
            return;
        }

        int bits = (size & (~(row | master | slave)));
        while(bits > 0) {
            int pick = bits & -bits;
            dfs(row | pick, (master | pick) >> 1, (slave | pick) << 1);
            bits = bits & (bits - 1);
        }
    }
}
