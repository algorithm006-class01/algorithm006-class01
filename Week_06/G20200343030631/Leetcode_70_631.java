/**
 * 暴力穷举，每次穷举，过程中记录不同目标的方法数，避免重复运算
 * 执行用时 :1 ms, 在所有 Java 提交中击败了51.10%的用户
 * 内存消耗 :34.2 MB, 在所有 Java 提交中击败了45.68%的用户
 */
class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.printf("Climb %s stairs hava %d ways!%n", i, climbStairs(i));
        }
    }

    public static int climbStairs(int n) {
        // 初始化一个历史记录数组，记录走过的不同目标的方法数
        int[] history = new int[n+1];
        return climbStair(n ,0, history);
    }

    /**
     * @param targetStair 要爬的楼梯数
     * @param currentStair 当前爬在第几阶楼梯
     * @param history 从不同阶梯到目标的方法数的记录数组，简化运算过程
     * @return 从当前阶楼梯到达目标楼梯的不同走法方法数
     */
    private static int climbStair(int targetStair, int currentStair, int[] history){
        // 如果已经超过目标楼梯阶数，则本次无需走
        if (currentStair > targetStair){
            return 0;
        }
        // 如果达到目标阶梯数，则表示需要走一步
        if (currentStair == targetStair){
            return 1;
        }
        // 如果从当前阶到达目标阶梯已经计算过，直接返回
        if (history[currentStair] > 0){
            return history[currentStair];
        }
        // 如果没有计算过，则计算结果，并记录在记录数组中
        history[currentStair] = climbStair(targetStair, currentStair+1, history) + climbStair(targetStair, currentStair+2, history);
        return history[currentStair];
    }
}