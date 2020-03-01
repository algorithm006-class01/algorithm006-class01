package G20200343030015.week_03;

/**
 * 122. 买卖股票的最佳时机 II
 * site:: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * Created by majiancheng on 2020/3/2.
 */
public class LeetCode_122_015 {

    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                res += prices[i] - prices[i-1];
            }
        }

        return res;
    }
}
