package leetcode.Week01;

public class LeetCode_70_535 {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 注意：给定 n 是一个正整数。
     *
     * 示例 1：
     *
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     *
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/climbing-stairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /***
     * 是否能暴力
     * 具体情况
     * 找重复性
     */

    public static int climbStairs1(int n) {
        /**递归方法：*/
        if (n == 1 || n == 0) {return 1;}
        else {
            return climbStairs1(n - 1) + climbStairs1(n - 2);
        }
    }

    /**
     * 思路：斐波那契数
     */

    public static int climbStairs2(int n) {
        if (n == 1){return 1;}
        if (n == 2){return 2;}
        int fn = 0;
        int f1 = 1;
        int f2 = 2;
        for (int i = 3; i <= n; i++) {
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }
      public static int climbStairs3(int N) {
              if(N == 0){ return 0;}
              if(N == 1){return 1;}
              int fn = 0;
              int f0 = 0;
              int f1 = 1;
              for(int i = 2; i <= N; i++){
                  fn = f0 + f1;
                  f0 = f1;
                  f1 = fn;
              }
              return fn;
         }



    public static void main(String[] args) {
        int n = 3;
        System.out.println("有多少种爬楼梯：" + climbStairs3(n));
    }
}
