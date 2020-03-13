#include <string.h>
#include <vector>
#include <iostream>
#include <climits>
#include <algorithm>
using namespace std;

/*
受到两个因素影响, 房子位置和是否偷窃，
状态数组: DP[i][j], i房子, j是否偷窃
DP[i][0] = max(DP[i-1][1], DP[i-1][0])
DP[i][1] = DP[i-1][0] + a[i]
*/

class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.size() == 0 ) return 0;
        vector<vector<int>> DP(nums.size(), vector<int>(2,0));

        DP[0][0] = 0;
        DP[0][1] = nums[0];

        for (int i = 1; i < nums.size(); i++){
            DP[i][0] = max(DP[i-1][1], DP[i-1][0]);
            DP[i][1] = DP[i-1][0] + nums[i];
        }
        return max(DP[nums.size()-1][1], DP[nums.size()-1][0]);

    }
};

int main(int argc, char *argv[]){
    vector<int> nums{1,2,3,1};
    Solution Sol;
    cout << Sol.rob(nums) << '\n';
    return 0;
}