/**
 * 解题思路: 只有小写字母，建一个26个字母的数组，存储字符出现次数
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 * 执行用时: 4 ms, 在所有 Java 提交中击败了95.85%的用户
 * 内存消耗: 40.1 MB, 在所有 Java 提交中击败了5.20%的用户
 *
 * @Author: loe881@163.com
 * @Date: 2020/4/5
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        int[] letters = new int[26];
        char[] strChars = s.toCharArray();
        for (char strChar : strChars) {
            letters[strChar - 'a'] += 1;
        }
        for (int i = 0; i < strChars.length; i++) {
            if (letters[strChars[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
