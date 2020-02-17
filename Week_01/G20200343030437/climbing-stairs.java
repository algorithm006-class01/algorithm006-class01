public int climbStairs(int n) {
            //根据反证法得出 该题是求斐波那契函数
            //单纯用菲波那切函数会有n^2的时间复杂度，所以换用简单方法
            if (n == 0) return 0;
            if (n == 1) return 1;

            int s0 = 1;
            int s1 = 1;
            int sum = 2;
            for (int i = 2; i < n; i++) {
                s0 = s1;
                s1 = sum;
                sum = s0 + s1;
            }
            return sum;
        }
