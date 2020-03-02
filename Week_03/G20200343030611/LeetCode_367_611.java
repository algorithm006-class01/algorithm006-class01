package datast.binary_search;

public class LeetCode_367_611 {

    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) return true;
        long r = num / 2;
        while (r * r > num) {
            r = (r + num / r) / 2;
        }
        return r * r == num;
    }
}
