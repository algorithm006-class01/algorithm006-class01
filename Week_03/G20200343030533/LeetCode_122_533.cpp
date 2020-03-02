// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/

//贪心算法，每次移动一天，如果第二天比今天高，就买，否则就不买
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if ( prices.size() == 0 ) return 0;
        int profit = 0;
        int i = 0;
        while (i < prices.size() - 1){
            if (prices[i] < prices[i+1]){
                profit += prices[i+1] - prices[i];
            }
            i++;    
        }
        return profit;

    }
};