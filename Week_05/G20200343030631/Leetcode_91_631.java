import java.util.HashMap;
import java.util.Map;

/**
 * 解题思路: 分情况讨论，如果当前字符为0，前一字符为1或者2，则dp[i] = dp[i-2]；如果当前字符不为0，只有取1位数字和两位数字两种情况，取1位时，到下一个字符需要考虑与前一位相连后是否存在于编码表，取两位时不需要考虑再取前一个字符
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 * 执行用时: 4 ms, 在所有 Java 提交中击败了28.70%的用户
 * 内存消耗: 38.9 MB, 在所有 Java 提交中击败了5.01%的用户
 */
public class Solution {
    // 存放数字与字符的映射
    private static Map<String, Character> codecDic = new HashMap<>();

    public static void main(String[] args) {
        Version2 version1 = new Version2();
        System.out.println(version1.numDecodings("1"));
        System.out.println(version1.numDecodings("12"));
        System.out.println(version1.numDecodings("226"));
        System.out.println(version1.numDecodings("262"));
        System.out.println(version1.numDecodings("0"));
        System.out.println(version1.numDecodings("10"));
        System.out.println(version1.numDecodings("101"));
        System.out.println(version1.numDecodings("00"));
        System.out.println(version1.numDecodings("100"));
        System.out.println(version1.numDecodings("110"));
        System.out.println(version1.numDecodings("301"));
        System.out.println(version1.numDecodings("27"));
    }

    private void prepareCodecDic() {
        // 按照ascii码生成
        for (int i = 65; i < 91; i++) {
            codecDic.put(String.valueOf(i - 64), (char) i);
        }
    }

    public int numDecodings(String s) {
        // 边界条件，需要考虑0开头特殊情况，0无映射关系
        if (null == s || s.length() == 0 || s.startsWith("0") || s.contains("00")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        // 生成映射关系
        prepareCodecDic();
        // dp数组
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if (!s.substring(0, 2).contains("0")) {
            if (codecDic.containsKey(s.substring(0, 2))) {
                dp[1] = 2;
            }else {
                dp[1] = 1;
            }
        }else {
            if (codecDic.containsKey(s.substring(0, 2))) {
                dp[1] = 1;
            }else {
                dp[1] = 0;
            }
        }

        for (int i = 2; i < s.length(); i++) {
            String prevTmpStr = s.substring(i - 1, i + 1);
            String currentTmpStr = s.substring(i, i + 1);
            if ("0".equals(currentTmpStr)) {
                if (codecDic.containsKey(prevTmpStr)) {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else if (codecDic.containsKey(prevTmpStr)) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }

}
