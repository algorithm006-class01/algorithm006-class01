package G20200343030391;

public class LeetCode_509_391 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int n = 999;
        int[] memo = new int[n + 1];
        memo[1] = 1;
        int fib1 = new LeetCode_509_391().fib_1(n);
//        int fib2 = new LeetCode_509_391_DP().fib_2(n);
//        int fib3 = new LeetCode_509_391_DP().fib_3(n, memo);

        long end = System.currentTimeMillis();
        System.out.println("结果：" + fib1 + " 耗时：" + (end - start));

    }

    /**
     * 傻递归
     * @param N
     * @return
     */
    public int fib_1(int N) {
        return N <= 1 ? N : fib_1(N - 1) + fib_1(N - 2);
    }

    /**
     * 自底向上
     * @param N
     * @return
     */
    public int fib_2(int N) {
        if (N <= 1) {
            return N;
        }
        int[] memo = new int[N + 1];
        memo[1] = 1;
        for (int i = 2; i <= N; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[N];
    }

    /**
     * 自顶向下
     *
     * @param N
     * @return
     */
    public int fib_3(int N, int[] memo) {
        if (N <= 1) {
            return N;
        }
        if (memo[N] == 0) {
            memo[N] = fib_3(N - 1, memo) + fib_3(N - 2, memo);
        }
        return memo[N];
    }

}
