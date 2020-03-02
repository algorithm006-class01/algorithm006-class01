class Solution {

    /**
     * x的平方根
     * 牛顿迭代法
     * 公式记忆方法：（要求的值 除以 当前值 + 当前值） / 2
     */
    public int mySqrt(int x) {
        int cur = x;
        while (cur * cur > x) {
            cur = (cur + x / cur) / 2;
        }
        return (int) cur;
    }

    /**
     * 二分查找法
     * 画一条1到x的线段，每次求出线段的中间位置
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}