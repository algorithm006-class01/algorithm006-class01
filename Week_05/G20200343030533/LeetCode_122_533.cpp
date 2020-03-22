#include <string.h>
#include <vector>
#include <iostream>
#include <climits>
#include <algorithm>
#include <stdio.h>
using namespace std;

/*子问题:
因为交易次数不受限制， 所以该问题就受到两个因素影响，时间和操作，因变量是利润，
因此需要用两个变量来定义定义问题
DP[i][j] 表示 第i天状态为j(0持有,1不持有)的情况下最大利润

DP[i][0] = max(DP[i-1][0], DP[i-1][1] + a[i])
DP[i][1] = max(DP[i-1][1], DP[i-1][1] - a[i]) 

分别为表示:
 第i天不持有，是前一天不持有，当天保持不变，或者是前一天持有，卖出去
 第i天持有，是前一天持有，当天保持不变，或者是前一天步持有，买进来
*/

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() == 0 ) return 0;
        int DP[prices.size()][2];
        for (int i = 0 ; i < prices.size(); i++ ){
            for (int j = 0; j < 2; j++){
                DP[i][j] = 0;
            }
        }
        DP[0][0] = 0;
        DP[0][1] = -prices[0];

        for (int i = 1 ; i < prices.size(); i++ ){
            DP[i][0] = max(DP[i-1][0], DP[i-1][1] + prices[i]);
            DP[i][1] = max(DP[i-1][1], DP[i-1][0] - prices[i]);
            printf("%d-%d\n", DP[i][0], DP[i][1]);
        }

    }
};


int main(int argc, char *argv[]){

    vector<int> prices{7,1,5,3,6};
    Solution sol;
    cout << sol.maxProfit(prices) << '\n';
    return 0;
}