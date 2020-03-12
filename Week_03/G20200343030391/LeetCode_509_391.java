package G20200343030391;

public class LeetCode_509_391 {

    public static void main(String[] args) {
        int fib = new LeetCode_509_391().fib_2(30);
        System.out.println(fib);

    }

    public int fib_1(int N) {
        if (N <= 1) {
            return N;
        }
        return fib_1(N - 1) + fib_1(N - 2);
    }
    public int fib_2(int N) {
        if (N <= 1) {
            return N;
        }
        int[] cache = new int[N + 1];
        cache[1] = 1;
        for (int i = 2; i <= N; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[N];
    }

}
