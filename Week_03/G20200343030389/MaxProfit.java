package follow.ice.phenix.leecode.week03;

/**
 * 买卖股票的最佳时机
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int money = prices[i] - prices[i + 1];
            if (money > 0) {
                result = result + money;
            }
        }
        return result;
    }
}
