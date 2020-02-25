// 50. Pow(x, n)
// https://leetcode-cn.com/problems/powx-n/
// 由于整型的正数比负数少了一位，因此最小值不能直接取负
// 必须要转换一下类型
class Solution {
public:
    double myPow(double x, int n) {
        int flag = 0;

        long long N = (long long)n;

        if (N < 0){
            N = - N;
            flag = 1;
        }

        return flag == 0 ? fastPow(x, N) : 1.0 / fastPow(x, N);
    

        
    }
    double fastPow(double x, long long n){
        if (n == 0 ) return 1;
        if (n == 1 ) return x;

        double result = fastPow(x, n / 2);

        return n % 2 == 0 ? result * result : result * result * x;

    }
};