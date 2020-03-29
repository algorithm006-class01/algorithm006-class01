/**
 * 解题思路: 移位操作方式，从低位开始，每次运算出当前位，然后左移31-index
 * 时间复杂度: O(1)
 * 空间复杂度: O(1)
 * 执行用时: 1 ms, 在所有 Java 提交中击败了0.00%的用户
 * 内存消耗: 38.4 MB, 在所有 Java 提交中击败了5.26%的用户
 *
 * @Author: loe881@163.com
 * @Date: 2020/3/29
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
        System.out.println(reverseBits(-3));
    }

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            // (n >> (31 - i) & 1 取得当前位是1还是0
            result = result | ((n >> (31 - i) & 1) << i);
        }
        return result;
    }
}
