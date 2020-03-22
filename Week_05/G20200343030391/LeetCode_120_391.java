package G20200343030391;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_120_391 {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(2);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        ArrayList<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);
        triangle.add(l1);
        triangle.add(l2);
        triangle.add(l3);
        triangle.add(l4);
        int i = new LeetCode_120_391().minimumTotal_2(triangle);
        System.out.println(i);
    }

    /**
     * 傻递归
     * @param triangle
     * @return
     */
    public int minimumTotal_1(List<List<Integer>> triangle) {
        int size = triangle.size();
        return help(0, 0, size, triangle);
    }

    private int help(int row, int clo, int level, List<List<Integer>> triangle) {
        //terminator 最后一行直接返回对应值
        if (row == level - 1) {
            return triangle.get(row).get(clo);
        }
        int left = help(row + 1, clo , level, triangle);
        int right = help(row + 1, clo + 1, level, triangle);
        return Math.min(left, right) + triangle.get(row).get(clo);
    }

    /**
     * 记忆化搜索
     * @param triangle
     * @return
     */
    public int minimumTotal_2(List<List<Integer>> triangle) {
        int size = triangle.size();
        Integer[][] memo = new Integer[size][size];
        return help(0, 0, size, memo, triangle);
    }

    private int help(int row, int clo, int level, Integer[][] memo, List<List<Integer>> triangle) {
        //取缓存结果
        if (memo[row][clo] != null) {
            return memo[row][clo];
        }
        //terminator 最后一行直接返回对应值
        if (row == level - 1) {
            return memo[row][clo] = triangle.get(row).get(clo);
        }
        int left = help(row + 1, clo, level, triangle);
        int right = help(row + 1, clo + 1, level, triangle);
        return memo[row][clo] = Math.min(left, right) + triangle.get(row).get(clo);
    }

    /**
     * 动态规划，自底向上
     *
     * @param triangle
     * @return
     */
    public int minimumTotal_3(List<List<Integer>> triangle) {
        //层数
        int row = triangle.size();
        int[] dp = new int[row + 1];
        //底部开始查找
        for (int level = row - 1; level >= 0; level--) {
            //当前行找下一行相邻的最小值+当前值
            for (int i = 0; i <= level; i++) {
                dp[i] = Math.min(dp[i], dp[i + 1]) + triangle.get(level).get(i);
            }
        }
        return dp[0];
    }
}
