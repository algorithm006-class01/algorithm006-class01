package Week_03.G20200343030395;

public class LeetCode_powxn {

    public double myPow(double x, int n) {
        long N = n;
        if(n < 0) {
            x = 1/x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        //结束
        if(n == 0) {
            return 1.0;
        }

        //子问题处理
        double helf = fastPow(x, n/2);

        //处理当前层
        if(n%2 == 0) {
            return helf * helf;
        } else {
            return helf * helf * x;
        }



    }
}
