/*
 * @lc app=leetcode.cn id=887 lang=java
 *
 * [887] 鸡蛋掉落
 *
 * https://leetcode-cn.com/problems/super-egg-drop/description/
 *
 * algorithms
 * Hard (21.09%)
 * Likes:    326
 * Dislikes: 0
 * Total Accepted:    17.8K
 * Total Submissions: 66K
 * Testcase Example:  '1\n2'
 *
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * 
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * 
 * 你的目标是确切地知道 F 的值是多少。
 * 
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * 
 * 
 * 示例 2：
 * 
 * 输入：K = 2, N = 6
 * 输出：3
 * 
 * 
 * 示例 3：
 * 
 * 输入：K = 3, N = 14
 * 输出：4
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= K <= 100
 * 1 <= N <= 10000
 * 
 * 
 */

// @lc code=start
class Solution {
    /*
     * 解决方案：动态规划
     *        状态：当前鸡蛋数目K，需要测试的楼层数N
     *        选择：在哪一层楼扔鸡蛋
     *        dp[K][N]含义：# 当前状态为 k 个鸡蛋，面对 n 层楼
     *                     # 这个状态下（最坏时）最少的扔鸡蛋次数为 m
     *        转移方程：dp[K][N] = min[i in 1~N](result, max(dp[K-1][i-1], dp[K][N-i]) + 1)
     * 时间复杂度：O(KN^2)
     * 空间复杂度：O(KN)
     * PS：时间超时
     */
    public int superEggDrop1(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 1; i <= K; i++) dp[i][1] = 1;
        for (int i = 1; i <= N; i++) dp[1][i] = i;
        for (int k = 2; k <= K; k++) for (int n = 2; n <= N; n++) {
            int result = n;
            for (int i = 1; i <= n; i++)
                result = Math.min(result, Math.max(dp[k-1][i-1], dp[k][n - i]) + 1);

            dp[k][n] = result;
        }
        return dp[K][N];
    }

    /*
     * 解决方案同上，仅改变将迭代求解（自底向上）转换为了递归求解(自顶向下)
     * PS：时间超时
     */
    public int superEggDrop2(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        return dpEGG(K, N, dp);
    }

    /*
     * 时间复杂度：O(K*N^2)
     * 空间复杂度：O(K*N)
     */
    public int dpEGG1(int K, int N, int[][] mem) {
        if (1 == K) return N;
        if (0 == N) return N;
        if (mem[K][N] > 0) return mem[K][N];

        int result = N;
        for (int i = 1; i <= N; i++)
            result = Math.min(result, Math.max(dpEGG(K - 1, i - 1, mem), dpEGG(K, N - i, mem)) + 1);
        
        mem[K][N] = result;
        return result;
    }

    /*
     * 自顶向下中适合用“二分来优化”
     * 二分搜索优化也只是做了「剪枝」，减小了搜索空间，但本质思路没有变，还是穷举。
     * 
     * 时间复杂度：O(K*N*logN)
     * 空间复杂度：O(K*N)
     */
    public int dpEGG(int K, int N, int[][] mem) {
        if (1 == K) return N;
        if (0 == N) return N;
        if (mem[K][N] > 0) return mem[K][N];

        int result = N, lo = 1, hi = N;
        // for (int i = 1; i <= N; i++)
        //     result = Math.min(result, Math.max(dpEGG(K - 1, i - 1, mem), dpEGG(K, N - i, mem)) + 1);
        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            int broken = dpEGG(K - 1, mid - 1, mem); // 碎了
            int not_broken = dpEGG(K, N - mid, mem); // 没碎
            if (broken > not_broken) {
                hi = mid - 1;
                result = Math.min(result, broken + 1);
            } else {
                lo = mid + 1;
                result = Math.min(result, not_broken + 1);
            }
        }
        
        mem[K][N] = result;
        return result;
    }

    /*
     * 解决方案：动态规划
     *        状态：当前鸡蛋数目K，最多允许扔鸡蛋的次数M
     *        选择：需要测试的楼层数N
     *        dp[k][m] = n 含义：# 当前有 k 个鸡蛋，可以尝试扔 m 次鸡蛋
     *                          # 这个状态下，最坏情况下最多能确切测试一栋 n 层的楼
     *        转移方程：dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1
     * 时间复杂度：O(KN)
     * 空间复杂度：O(KN)
     * PS：时间超时
     */
    public int superEggDrop3(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        int m = 0;
        while (dp[K][m] < N ) {
            m++;
            for (int k = 1; k <= K; k++)
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
        }
        return m;
    }

    /*
     * 解决方案：动态规划
     *        状态：当前鸡蛋数目K，最多允许扔鸡蛋的次数M
     *        选择：需要测试的楼层数N
     *        dp[k][m] = n 含义：# 当前有 k 个鸡蛋，可以尝试扔 m 次鸡蛋
     *                          # 这个状态下，最坏情况下最多能确切测试一栋 n 层的楼
     *        转移方程：dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1
     * 时间复杂度：O(KN)
     * 空间复杂度：O(K)
     * PS：优化空间复杂度
     */
    public int superEggDrop(int K, int N) {
        int dp[] = new int[K + 1];
        int m = 0;
        while (dp[K] < N) {
            m++;
            // 下面这种写法有问题，在计算未完全结束前，本m层的计算结果提前覆盖了m-1层的结果；
            // for (int k = 1; k <= K; k++)
            //     dp[k] += (dp[k - 1] + 1);
            
            for (int k = K; k > 0; k--)
                dp[k] += (dp[k - 1] + 1);
        }
        return m;
    }
}
// @lc code=end

