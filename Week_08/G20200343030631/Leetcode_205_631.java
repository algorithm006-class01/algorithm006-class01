
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 解题思路: 同构即字符串构造相同，字符可以不同，忽略字符差异，统计每个字符串字符出现位置，计算字符串构造数组，判断两个构造数组是否相同
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 * 执行用时: 18 ms, 在所有 Java 提交中击败了29.36%的用户
 * 内存消耗: 40.2 MB, 在所有 Java 提交中击败了5.17%的用户
 *
 * @Author: loe881@163.com
 * @Date: 2020/4/5
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> sCounter = new HashMap<>(s.length());
        Map<Character, Integer> tCounter = new HashMap<>(t.length());
        for (int i = 0; i < s.length(); i++) {
            if (!sCounter.keySet().contains(s.charAt(i))){
                sCounter.put(s.charAt(i), i);
            }
            if (!tCounter.keySet().contains(t.charAt(i))){
                tCounter.put(t.charAt(i), i);
            }
        }

        int[] sConstruct = new int[s.length()];
        int[] tConstruct = new int[t.length()];
        for (int i = 0; i < s.length(); i++) {
            sConstruct[i] = sCounter.get(s.charAt(i));
            tConstruct[i] = tCounter.get(t.charAt(i));
        }
        return Arrays.equals(sConstruct, tConstruct);
    }
}
