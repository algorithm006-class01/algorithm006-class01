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
public class LeetCode_51_379_3 {


    private int size;
    private int count;
    /**
     * 执行用时 : 51 ms , 在所有 Java 提交中击败了 5.14% 的用户
     * 内存消耗 : 43.6 MB , 在所有 Java 提交中击败了 5.18% 的用户
     * @param n
     * @return
     */
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        dfs(n,new ArrayList<>(),0,0,0,0);
        conver(res);
        return res;
    }

    private void conver(List<List<String>> res) {
        for (List<String> re : res) {
            for (int i = 0; i < re.size(); i++) {
                String q = String.format("%" + String.valueOf(re.size()) + "s"
                        //如果 0001001  则把0 替换为"."
                        , re.get(i)).replaceAll("[\\s|0]", ".")
                        .replaceAll("1", "Q");
                re.set(i,q);
            }
        }
    }

    private void dfs(int n, List<String> board,
                     int r, int c, int lr, int ll) {
        if(r==n){
            res.add(new ArrayList<>(board));
            return;
        }

        int bit = (~(c | lr | ll)) & ((1<<n) - 1);
        while (bit !=0){
            //获取最低位
            int q=bit & (-bit);
            // %ns,q的二进制
            board.add(Integer.toBinaryString(q));
            dfs(n,board,r+1 , c|q ,(lr | q)>>1,(ll | q)<<1);
            board.remove(r);
            bit = bit & (bit-1);
        }
    }

    private void dfs2(int n, List<String> board,
                     int r, int c, int lr, int ll) {
        if(r==n){
            res.add(board);
            return;
        }

        int bit = (~(c | lr | ll)) & ((1<<n) - 1);
        while (bit !=0){
            //获取最低位
            int q=bit & (-bit);
            // %ns,q的二进制
            board.add(String.format("%"+String.valueOf(n)+"s"
                    //如果 0001001  则把0 替换为"."
                    , Integer.toBinaryString(q)).replaceAll("[\\s|0]",".")
                .replace("1","Q"));
            dfs(n,new ArrayList<>(board),r+1 , c|q ,(lr | q)>>1,(ll | q)<<1);
            board.remove(r);
            bit = bit & (bit-1);
        }
    }

    public static void main(String[] args) {
        String s = "000010001".replaceAll("[\\s|0]", ".");
        System.out.println(s);
        String.format("%"+String.valueOf(2)+"s","2312");

        new LeetCode_51_379_3().solveNQueens(4);
    }

    private void solve(int row, int ld, int rd) {
        if(row==size){
            count++;
            return;
        }
        int pos=size & (~(row | ld | rd));

        while (pos != 0 ){
            int p=pos & (-pos);
            pos -= p;
            solve(row | p,(ld | p) << 1 ,
                    (rd | p)>> 1);
        }
    }

}