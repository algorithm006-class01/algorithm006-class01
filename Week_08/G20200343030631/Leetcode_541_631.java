
/**
 * 解题思路: 转换为字符数组，对数组以2k个为对进行处理，剩余长度小于k时，整体处理
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 * 执行用时: 2 ms, 在所有 Java 提交中击败了51.25%的用户
 * 内存消耗: 39.4MB, 在所有 Java 提交中击败了5.81%的用户
 *
 * @Author: loe881@163.com
 * @Date: 2020/4/5
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
        System.out.println(reverseStr("abcdefg", 8));
    }

    public static String reverseStr(String s, int k) {
        char[] strChars = s.toCharArray();
        int length = s.length();
        for (int i = 0; i < length; i += k * 2) {
            int start = i;
            int end = Math.min(i + k - 1, length - 1);
            while (start < end) {
                char tmp = strChars[start];
                strChars[start++] = strChars[end];
                strChars[end--] = tmp;
            }
        }
        return new String(strChars);
    }
}
