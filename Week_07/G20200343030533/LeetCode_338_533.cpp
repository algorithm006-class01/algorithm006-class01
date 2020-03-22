//北美互联网出现的比较堵，国内不清楚

class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> res(num+1, 0);

        for (int i = 1; i <= num; i++){
            res[i] = 1 + res[ i & (i-1)];
        }
        return res;

    }
};

/* 找规律: res[i] = 1 + res[i &(i-1)]
0: 0000
1: 0001
2: 0010
3: 0011
4: 0100
5: 0101
6: 0110
7: 0111
8: 1000
*/
