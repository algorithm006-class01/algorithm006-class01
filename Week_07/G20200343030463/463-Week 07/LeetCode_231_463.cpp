学习笔记

class Solution {
public:
    bool isPowerOfTwo(int n) {
        if (n ==0) return false;
        while(n%2==0) n/=2; //不算除以2 得到商
        return n==1;
    }
};

class Solution {
public:
    bool isPowerOfTwo(int n) {
        if (n==0) return false;
        long x = n;
        return (x&(x-1)) == 0; //位运算 将最右边的 1 设置为 0。
    }
};

class Solution {
public:
    bool isPowerOfTwo(int n) {
        if (n==0) return false;
        long x = n;
        return (x & (-x)) == x; //-x=~x+1
    }
};
