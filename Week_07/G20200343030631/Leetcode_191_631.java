
/**
 * 解题思路: 位运算思路，每次去掉最后一个1，统计执行次数
 * 时间复杂度: O(1)，常数级，依赖于1的个数
 * 空间复杂度: O(1)，不需要额外空间
 * 执行用时: 1 ms, 在所有 Java 提交中击败了99.75%的用户
 * 内存消耗: 36.6 MB, 在所有 Java 提交中击败了5.58%的用户
 *
 * @Author: loe881@163.com
 * @Date: 2020/3/28
 */
public class Solution {
    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(hammingWeight(n));
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            n = n & (n - 1);
            result++;
        }
        return result;
    }
}
