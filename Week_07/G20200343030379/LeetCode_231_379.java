package G20200343030379;

/**
 * 231. 2的幂
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例?1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20?= 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24?= 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 参考优秀题解：
 */
public class LeetCode_231_379 {

    public static void main(String[] args) {
        //十进制转二进制
        String s = Integer.toBinaryString(-2147483648);
        new LeetCode_231_379().isPowerOfTwo(-2147483648);
    }

    /**
     * x & x-1 清零最低位：由于2的幂，只有最高位1，就可以知道是否幂的值
     *
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00%的用户
     * 内存消耗 : 37 MB , 在所有 Java 提交中击败了 5.50% 的用户
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        long x = (int)n;
        return x!=0 && (x & x-1)==0;
    }

    /**
     * x & (-x) 得到最低位的1:由于只有最高位是1，所以获取最高的值，相等说明是幂的值。
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 36.5 MB , 在所有 Java 提交中击败了 5.50% 的用户
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n) {
        long x = (int)n;
        return x!=0 && (x & (-x))==x;
    }


}
