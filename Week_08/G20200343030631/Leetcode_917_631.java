
/**
 * 解题思路: 双指针一个从0，一个从lenth-1开始，碰到非字符则跳过
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 * 执行用时: 1 ms, 在所有 Java 提交中击败了83.50%的用户
 * 内存消耗: 38.1 MB, 在所有 Java 提交中击败了5.19%的用户
 *
 * @Author: loe881@163.com
 * @Date: 2020/4/5
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj").equals("j-Ih-gfE-dCba"));
    }

    public static String reverseOnlyLetters(String S) {
        int length = S.length();
        char[] strChars = S.toCharArray();
        for (int i = 0, j = length - 1; i <= j; ) {
            if (Character.isLetter(strChars[i])) {
                while (!Character.isLetter(strChars[j])) {
                    j--;
                }
                char tmp = strChars[i];
                strChars[i] = strChars[j];
                strChars[j] = tmp;
                j--;
            }
            i++;
        }
        return new String(strChars);
    }
}
