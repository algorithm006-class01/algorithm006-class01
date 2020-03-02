//69. x 的平方根
//https://leetcode-cn.com/problems/sqrtx/

//注意点:
// 溢出 mid * mid 可能会溢出, 因此用除法
// 因为用除法，要小心0和1
// 最后返回left-1, 因为最终是left== right, 而right是大于结果的。
// left 肯定大于1
class Solution {
public:
    int mySqrt(int x) {

        if (x == 0 || x == 1) return x;

        int left = 1, right = x;
        int mid;

        while (left <= right){
            mid = left + ((right-left) >> 1);
            if (mid == x / mid){
                return mid;
            } else if ( mid < x / mid){
                left = mid + 1;
            } else{
                right = mid -1;
            }
        }
        return left-1;

    }
};

//牛顿迭代法
//https://www.beyond3d.com/content/articles/8/
//注意，long long r, 否则溢出
class Solution {
public:
    int mySqrt(int x) {
        if ( x== 0 || x == 1) return x;
        long long r = x;
        while(r *r > x){
            r = ( r + x /r ) >> 1;
        }
        return r;

    }
};