package bitwise;

/**
 * https://leetcode-cn.com/problems/power-of-two/
 * Created by bluzelee on 2020/3/29.
 */
public class PowerOfTwo02 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & n - 1) == 0;
    }

    public static void main(String[] args) {
        PowerOfTwo02 two02 = new PowerOfTwo02();
        System.out.println(two02.isPowerOfTwo(218));
    }

}
