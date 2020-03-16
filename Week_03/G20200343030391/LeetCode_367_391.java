package G20200343030391;

public class LeetCode_367_391 {

    public static void main(String[] args) {
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println(new LeetCode_367_391().isPerfectSquare(808201));
//        }
    }

    /**
     * 二分
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        long left = 2, right = num / 2;
        while (left <= right) {
            long x = left + (right - left) / 2;
            long square = x * x;
            if (square == num) {
                return true;
            }
            if (square > num) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return false;
    }
}
