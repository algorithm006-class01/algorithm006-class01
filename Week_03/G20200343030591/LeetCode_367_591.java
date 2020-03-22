class Solution {

    /**
     * 有效的完全平方数
     * 在求平方根的基础上 判断 最终求出的值是否是完全平方数
     * 即 1 * 1， 2 * 2， 3 * 3
     * 1、4、9 这种都属于完全平方数
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        int left = 1, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > num / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right * right == num;
    }

    /**
     * 牛顿迭代法
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        long cur = num;
        while (cur * cur > num) {
            cur = (cur + num / cur) / 2;
        }
        return (int)(cur * cur) == num;
    }
}