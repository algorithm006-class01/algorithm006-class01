/*
 * @lc app=leetcode.cn id=69 lang=cpp
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
public:
    int mySqrt(int x) {
        long long i=0;
        long long j=x/2+1;
        while (i<=j)
        {
            long long mid=(i+j)/2;
            long long res=mid*mid;
            if(res==x)
                return mid;
            else if(res<x)
                i=mid+1;
            else
                j=mid-1;
        }
        return j;
    }
};

// class Solution{
// public:/*牛顿迭代法，还不太理解*/
//     int mySqrt(int x){
//         if(x==0)
//             return 0;
//         double last=0;
//         double res=1;
//         while(res!=last){
//             last=res;
//             res=(res+x/res)/2;
//         }
//         return int(res);
//     }
// };
// @lc code=end

