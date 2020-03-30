package G20200343030015.week_07;

/**
 * Created by majiancheng on 2020/3/29.
 * 231. 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */
public class LeetCode_231_015 {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;

        return (n & (n - 1)) == 0;
    }
}
