package datast.dp;

public class LeetCode_509_611 {

    class Solution {
        public int fib(int N) {
            if ( N < 2) return N;
            int f1 = 0, f2 = 1, f3 = 1;
            for (int i = 2; i <= N; i++){
                f3 = f1 + f2;
                f1 = f2;
                f2 = f3;
            }
            return f3;
        }
    }
}
