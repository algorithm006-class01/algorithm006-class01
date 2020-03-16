#include <string.h>
#include <vector>
#include <iostream>
#include <climits>
#include <algorithm>
using namespace std;

/*
a.子问题: 第i个位置可达 = 前0..i-1中有个位置可达 + 对应最大步数 > i
b.状态数组: DP[i], true/false
c.DP方程: DP[i] = 0..i-1 + a[i] > 0 
时间复杂度是O(n^2), 超时
*/
class Solution1 {
public:
    bool canJump(vector<int>& nums) {
        vector<bool> valid(nums.size(), false);
        valid[0] = true;
        for ( int i = 1; i < nums.size(); i++){
            for (int j = 0; j < i; j++){
                if ( valid[j] && j + nums[j] >= i){
                    valid[i] = true;
                    break;
                }
            }
        }
        return valid[nums.size()-1];

    }
};

/*
尝试从后往前递归，但是时间复杂度还是O(n^2), 还是超时
*/
class Solution2 {
public:
    int mymin(int i, int j ){
        return i < j ? i :j;
    }
    bool canJump(vector<int>& nums) {
        vector<bool> valid(nums.size(), false);
        valid[valid.size()-1] = true;
        for ( int i = nums.size() - 2; i >= 0; i--){
            int jump = mymin( i + nums[i], nums.size() - 1 );
            for (int j = i+1; j <= jump; j++){
                if ( valid[j] ){
                    valid[i] = true;
                    break;
                }
            }
        }
        return valid[0];

    }
};

/*
从后往前，不断更新last的位置
last - i <= nums[i] , 上一个能抵达的位置和当前位置相比, 是否比现在位置能去的最远路程远
*/
class Solution {
public:
    bool canJump(vector<int>& nums) {
        int last = nums.size() - 1;
        for(int i = nums.size() - 2; i >= 0; i--) 
            if(last - i <= nums[i]) last = i;
        return last == 0;
    }
};



int main(int argc, char *argv[]){
    return 0;
}