题目:买卖股票的最佳时机 II
解法如下 贪心算法

解法一:
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit = 0;
        for (int i =1; i < prices.size();i++){
            if (prices[i] > prices[i-1]){
                profit += (prices[i]-prices[i-1]);
            }
        }
        return profit;
    }
};

解法二: 国际站投票最高的解法
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int ret = 0;
        for (size_t p = 1; p < prices.size(); ++p)
            ret += max(prices[p] - prices[p - 1], 0);
        return ret;
    }
};
