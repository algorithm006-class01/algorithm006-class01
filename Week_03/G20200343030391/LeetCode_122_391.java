package G20200343030391;

public class LeetCode_122_391 {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = new LeetCode_122_391().maxProfit(prices);
        System.out.println(i);

        int[] prices1 = {1, 2, 3, 4, 5};
        int i1 = new LeetCode_122_391().maxProfit(prices1);
        System.out.println(i1);

        int[] prices3 = {7, 6, 3, 2};
        int i3 = new LeetCode_122_391().maxProfit(prices3);
        System.out.println(i3);
    }

    /**
     * 贪心
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            //卖出
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
