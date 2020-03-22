//题目链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
class Solution {
    /**
     * 方法1: 暴力法; 计算与所有可能的交易组合相对应的利润，并找出它们中的最大利润
     * 时间复杂度: 时间复杂度：O(n^n)，调用递归函数 n^n次
     * 空间复杂度: O(n)，递归的深度为 n
     */
    public int maxProfit1(int[] prices, int s) {
        if (s >= prices.length)
            return 0;
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxprofit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxprofit)
                        maxprofit = profit;
                }
            }
            if (maxprofit > max)
                max = maxprofit;
        }
        return max;
    }

    /**
     * 方法2: 峰谷法
     * 时间复杂度: 时间复杂度：O(n)，遍历一次
     * 空间复杂度: O(1),需要常量的空间
     */
    public int maxProfit2(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }


    /**
     * 方法2: 简单的一次遍历; 第二个数字大于第一个数字,获得的总和将是最大利润
     * 时间复杂度: 时间复杂度：O(n)，遍历一次
     * 空间复杂度: O(1),需要常量的空间
     */
    public int maxProfit3(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}