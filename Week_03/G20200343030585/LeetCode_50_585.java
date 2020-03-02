
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        
        if (N < 0) {
            x = 1/x;
            N = -N;
        }
        return fastPow(x, N);        
    }

    public double fastPow(double x, long n) {
        // terminator
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
       
        // current level logic
        double ret = fastPow(x, n/2);        

        // drill down

        // reverse
        if (n % 2 == 1) {
            ret = ret * ret * x;   
        } else {
            ret = ret * ret;
        }
        return ret; 
    }

    public static void main(String args[]) { 
        Solution obj = new Solution();

        System.out.println(obj.myPow(1, -2147483648));
    }
}