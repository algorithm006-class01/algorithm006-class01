package G20200343030379;


import java.util.ArrayList;
import java.util.List;

/**
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
public class LeetCode_51_379_0 {
    public static void main(String[] args) {
       List<List<String>> strings = new LeetCode_51_379_0().solveNQueens(4);
        System.out.println(strings);
       new LeetCode_51_379_0().construct(new char[][]{{'1','2'}});


    }

    /**
     * 执行用时 : 17 ms , 在所有 Java 提交中击败了 9.57% 的用户
     * 内存消耗 : 41.4 MB , 在所有 Java 提交中击败了 5.86% 的用户
     *
     * 缺点：1、数组结构组装比较混乱
     *      2、去掉非法选项算法靠暴力，不够优化
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        //N皇后结构
        List<List<String>> nStrut=new ArrayList<>();
        for (int i = 1; i <=n; i++) {
            List list = new ArrayList<>(n);
            for (int j = 1; j <= n; j++) {
                list.add(".");
            }
            nStrut.add(list);
        }

        //存储可能的所有结果
        List<List<String>> res=new ArrayList<>();
        boardtrack(res,nStrut,0);

        return res;
    }

    //手动清除法

    /**
     *
     * @param res       当前初始化完的N皇后结构，每个格子都是“.”
     * @param nStrut    保存最后选择的所有结果
     * @param row       行
     */
    private void boardtrack(List<List<String>> res,List<List<String>> nStrut,
                            int row) {
        //1、退出标志
        if(row==nStrut.size()){
            res.add(construct(nStrut));
            return;
        }

        //2、执行逻辑
        //2、遍历列
        for (int i = 0; i < nStrut.size(); i++) {
            //2.1、检查是否是在攻击范围
            if(!isVaild(nStrut,row,i)){
                continue;
            }
            //2.2、进步下一层
            List<String> strings = nStrut.get(row);
            strings.set(i,"Q");
            boardtrack(res,nStrut,row+1);
            //2.3、清除收尾，撤销上一步
            strings.set(i,".");
        }
    }

    /**
     * 校验当前位置是否可用，不属攻击范围
     * true 可用  false 非可用，会被攻击
     * @param list 当前选择的结果
     * @param row  行
     * @param col  列
     * @return
     */
    private boolean isVaild(List<List<String>> list, int row, int col) {
        //检查当前列是否属攻击范围
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i).get(col);
            if(s.equals("Q")){
                return false;
            }
        }

        //检查左上面是否属攻击范围，先排除自身
        for(int i=row-1,j=col-1; i>=0 && j>=0;i--,j--){
            //获取i行j列
            String s = list.get(i).get(j);
            if(s.equals("Q")){
                return false;
            }
        }

        //检查右上方是否属攻击范围，先排除自身
        for(int i=row-1,j=col+1;i>=0 && j<list.size();i--,j++){
            //获取i行j列
            String s = list.get(i).get(j);
            if(s.equals("Q")){
                return false;
            }
        }
        return true;
    }

    //把当前选择的结构，组织成一个List<String> 类似为：[{"..Q.","...Q"}]
    private List<String> construct(List<List<String>> board) {
        List<String> list=new ArrayList<>();
        for (int i = 0; i < board.size(); i++) {
            StringBuilder sb=new StringBuilder();
            List<String> s = board.get(i);
            for (int j = 0; j < s.size(); j++) {
                sb.append(s.get(j));
            }
            list.add(sb.toString());
        }
        return list;
    }


    /****/
    private List<String> construct(char[][] board) {
        List<String > list=new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            list.add(s);
        }
        return list;
    }



}
