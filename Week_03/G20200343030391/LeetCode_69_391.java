package G20200343030391;

public class LeetCode_69_391 {

    public static void main(String[] args) {
        int i = new LeetCode_69_391().mySqrt(36);
        System.out.println(i);
    }

    /**
     * 二分查找
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long left = 0, right = x;
        long mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) right;
    }
}
