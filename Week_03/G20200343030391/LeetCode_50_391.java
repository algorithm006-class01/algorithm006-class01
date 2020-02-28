package G20200343030391;

import java.util.List;

public class LeetCode_50_391 {

    public static void main(String[] args) {
        double x = -2.123;
        int n = -10;
        double pow = new LeetCode_50_391().myPow(x, n);
        assert pow == Math.pow(x, n);
    }

    /**
     * 分治
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        //terminator
        if (n == 0) {
            return 1.0;
        }
        //process(split the big problem)
        //drill down
        double pow = fastPow(x, n / 2);
        //merge(subResult)
        if (n % 2 == 0) {
            pow *= pow;
        } else {
            pow = pow * pow * x;
        }
        //reverse states
        return pow;
    }

}
