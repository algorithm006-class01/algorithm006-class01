
class LeetCode_192_505 {
    public boolean isPowerOfTwo(int n) {
        //n-1 & n 如果1的个数为1 相与的结果一定为0
        return n > 0 && (((n-1) & n) == 0);
    }
}