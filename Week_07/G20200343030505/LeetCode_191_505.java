
class LeetCode_192_505 {
   // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            ++cnt;

            //比如011 需要两次操作就变成0
            //比如1000 一次操作就变成了0
            //次数就是1的个数
            n = (n-1) & n;
        }
        return cnt;
    }
}

class LeetCode_192_505 {
     // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt += n & 1;
            n = n >>> 1;
        }
        return cnt;
    }
}