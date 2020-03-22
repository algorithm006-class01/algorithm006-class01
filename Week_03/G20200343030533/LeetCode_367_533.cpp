//
class Solution {
public:
    bool isPerfectSquare(int num) {
        if ( num == 0 ) return false;
        if ( num == 1) return true;

        int left = 1,  right = num;
        long long mid;
        while (left <= right){
            mid = left + ( (right-left) >> 1);
            if ( mid * mid == num){
                return true;
            } else if ( mid * mid > num){
                right = mid -1;
            } else{
                left = mid + 1;
            }
        }
        return false;

    }
};



//完全平方数的性质，从1开始的n个奇数的和是完全平方数。
class Solution {
public:
    bool isPerfectSquare(int num) {
        int num1 = 1;
        while (num > 0){
            num -= num1;
            num1 += 2;
        }
        return num == 0;

    }
};
