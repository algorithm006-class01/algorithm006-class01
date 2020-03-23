#include<unordered_map>

// 爬楼梯, 剪枝

class Solution {
std::unordered_map<int,int> dict;
public:
    int climbStairs(int n) {
        if ( n  == 0 ) return 1;
        if ( n <= 2 ) return n;

        if ( dict.find(n) != dict.end() ) return dict[n];
        dict[n] = climbStairs(n-1) + climbStairs(n-2);
        return dict[n];

    }
};