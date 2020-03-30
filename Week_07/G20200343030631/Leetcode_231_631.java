/**
 * 解题思路: 位运算方式，清零最低位的1：x&(x-1)，如果是2的n次幂，则清零后位0，此处需要注意Integer.MIN_VALUE取反后的溢出问题
 * 时间复杂度: O(1)
 * 空间复杂度: O(1)
 * 执行用时: 1 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗: 36.9 MB, 在所有 Java 提交中击败了5.50%的用户
 *
 * @Author: loe881@163.com
 * @Date: 2020/3/28
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(218));
    }

    public static boolean isPowerOfTwo(int n) {
        if (0 == n) {
            return false;
        }
        long x = n;
        return (x & (x-1)) == 0;
    }
}
