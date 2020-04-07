
/**
 * 解题思路: 分割字符串，分别对单词处理后再次拼接
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 * 执行用时: 8 ms, 在所有 Java 提交中击败了58.45%的用户
 * 内存消耗: 39.9 MB, 在所有 Java 提交中击败了6.23%的用户
 *
 * @Author: loe881@163.com
 * @Date: 2020/4/5
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(new StringBuilder(string).reverse().toString()).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
