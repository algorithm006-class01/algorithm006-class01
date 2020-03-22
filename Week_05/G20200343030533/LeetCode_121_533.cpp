#include <string.h>
#include <vector>
#include <iostream>
#include <climits>
#include <algorithm>
#include <stdio.h>
using namespace std;

/*子问题:
一次完整的操作 = 一次买入和一次卖出
该问题就受到三个因素影响，时间和操作和次数，因变量是利润，

因此需要用三个变量来定义定义问题
DP[i][j][k] 表示 第i天状态为j(0持有,1不持有),且操作次数为k(k=0,1)的情况下最大利润

总计有i * j * k = i * 2 * 2  = 4i种 状态

DP[i][0][0] = DP[i-1][0][0] ; //之前没有操作
DP[i][0][1] = max(DP[i-1][0][1] + DP[i-1][1][0] + a[i]); // 不操作, 或者之前持有后卖出构成一次完成操作
DP[i][1][0] = max(DP[i-1][1][0] + DP[i-1][0][0] - a[i]); //不操作，或者之前不持有，现在持有，形成一半操作
DP[i][1][1] ;// 不存在,因为一次完整的操作后，最终一定不持有。


*/

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() == 0 ) return 0;
        int DP[prices.size()][2][2];
        for (int i = 0 ; i < prices.size(); i++ ){
            for (int j = 0; j < 2; j++){
                for (int k = 0; k < 2; k++ )
                DP[i][j][k] = 0;
            }
        }
        DP[0][0][0] = 0;
        DP[0][1][0] = -prices[0]; //买入
        
        for (int i = 1 ; i < prices.size(); i++ ){
            DP[i][0][0] = DP[i-1][0][0];
            DP[i][1][0] = max(DP[i-1][1][0], DP[i-1][0][0] - prices[i]);
            DP[i][0][1] = max(DP[i-1][0][1], DP[i-1][1][0] + prices[i]);
        }
        return DP[prices.size()-1][0][1];

    }
};



int main(int argc, char *argv[]){

    vector<int> prices{7,1,5,3,6};
    Solution sol;
    cout << sol.maxProfit(prices) << '\n';
    return 0;
}