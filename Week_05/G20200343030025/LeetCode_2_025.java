/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class LeetCode_2_025 {
    // a. 重复子问题 opt[i] = opt[i-1] + opt[i-2]
    // b. 状态空间 opt[i]
    // c. DP 方程 f(n) = f(n-1) + f(n-2)

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int[] opt = new int[s.length() + 1];
        opt[0] = opt[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            //如果该位不为'0'，说明该位单独成字母合法
            if (s.charAt(i - 1) != '0') {
                opt[i] += opt[i - 1];
            }

            //如果后两位能组成"1x"（x为任意数字）或者"2x"（x小于7），说明最后两位组成字母合法
            if ((s.charAt(i - 2) == '1') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                opt[i] += opt[i - 2];
            }
        }
        return opt[s.length()];
    }
}