/*
 * @lc app=leetcode.cn id=122 lang=cpp
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution
{
public:
    int maxProfit(vector<int> &prices)
    {
        if(prices.size()==0)
            return 0;
            int count=0,max=0;
            for (int i = 1; i < prices.size(); i++)
            {
                if(prices[i]>prices[i-1]&&i!=prices.size()-1)
                    count++;
                else if(prices[i]<=prices[i-1]&&count>0){
                    max=prices[i-1]-prices[i-1-count]+max;
                    count=0;
                }
                else if(prices[i]>prices[i-1]&&i==prices.size()-1){
                    max=prices[i]-prices[i-count-1]+max;
                }
            }
           return max;

    }
};
// class Solution
// {
// public:
//     int maxProfit(vector<int> &prices)
//     {
//         if (prices.size() == 0)
//             return 0;
//         int max = 0;
//         for (int i = 1; i < prices.size(); i++)
//             if (prices[i] > prices[i - 1])
//                 max = prices[i] - prices[i - 1] + max;
//         return max;
//     }
// };

// @lc code=end