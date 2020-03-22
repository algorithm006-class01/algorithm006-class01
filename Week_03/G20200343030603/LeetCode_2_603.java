class Solution {
    //方法一：暴力法，递归
    // public int maxProfit(int[] prices) {
    //     return calculate(prices, 0);
    // }

    // public int calculate(int prices[], int s){
    //     if (s >= prices.length) {
    //         return 0;
    //     }

    //     int max = 0;
    //     for (int start = s; start < prices.length; start++){
    //         int maxProfit = 0;
    //         for (int i = start + 1; i < prices.length; i++){
    //             if (prices[start] < prices[i]) {
    //                 int profit = calculate(prices, i + 1) + prices[i] - prices[start];
    //                 if (profit > maxProfit) {
    //                     maxProfit = profit;
    //                 }
    //             }
    //             if (maxProfit > max) {
    //                 max = maxProfit;
    //             }
    //         }
    //     }
    //     return max;
    // }


    //第二种：峰谷法 时间复杂度O(n) 空间复杂度O(1)
     public int maxProfit(int[] prices) {
         if (prices.length == 0){
             return 0;
         }
         int i = 0;
         int valley = prices[0];
         int peak = prices[0];
         int maxProfit = 0;
         while(i < prices.length - 1) {
             if (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
             }
                
             valley = prices[i];
             
             if (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
             }
                 
             peak = prices[i];
             maxProfit += peak - valley;
        }

         return maxProfit;
     }


    //  // 方法三：简单的一次遍历，差值相加（可以当天卖出当天买入，实际就没卖出）时间复杂度O(n) 空间复杂度O(1)
    //  public int maxProfit(int[] prices) {
    //      int maxProfit = 0;
    //      for (int i = 1; i < prices.length; i++){
    //          if (prices[i] > prices[i - 1]) {
    //              maxProfit += prices[i] - prices[i - 1];
    //          }
    //      }
    //      return maxProfit;
    // }

}