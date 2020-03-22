package greedy;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuySellStock {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuySellStock sellStock = new BestTimeToBuySellStock();

        int[] prices = new int[]{7,6,4,3,1};
        System.out.println(sellStock.maxProfit(prices));

    }
}
