package G20200343030379;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  322. 零钱兑换
 *
 *  给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回?-1。
 *
 * 示例?1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  优秀题解：
 */



public class LeetCode_322_379 {
    public static void main(String[] args) {
        new LeetCode_322_379().coinChange(new int[]{186,419,83,408},6249);
    }

    /**
     * 贪心算法有问题
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int count=0;
        if(amount==0) return 0;

        for (int i = coins.length-1; i >= 0; i--) {
            int chu=amount/coins[i];
            count+=chu;
            if(chu==0) continue;
            //可以整除
            amount=amount-(chu*coins[i]);

            if(amount==0){
                return count;
            }
        }


        return -1;

    }

}
