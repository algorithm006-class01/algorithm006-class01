package datast.binary_search;

public class LeetCode_69_611 {

    public int mySqrt(int x) {
        if (x == 1) return 1;
        // 首先随便猜一个近似值x，然后不断令x等于x和a/x的平均数，迭代个六七次后x的值就已经相当精确了
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
}
