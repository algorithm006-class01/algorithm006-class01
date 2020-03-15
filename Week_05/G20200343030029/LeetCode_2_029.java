class LeetCode_2_029 {

	/**
	 * 题目描述：一条包含字母 A-Z 的消息通过以下方式进行了编码：
	 * <p>
	 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 给定一个只包含数字的非空字符串，请计算解码方法的总数。
	 * <p>
	 * 示例 1:
	 * <p>
	 * 输入: "12" 输出: 2 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
	 * <p>
	 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/decode-ways 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public int numDecodings(String s) {
		if (s.charAt(0) == '0')
			return 0;

		int[] dp = new int[s.length() + 1];
		dp[0] = dp[1] = 1;

		for (int i = 2; i <= s.length(); i++) {
			//如果该位不为'0'，说明该位单独成字母合法
			if (s.charAt(i - 1) != '0') {
				dp[i] += dp[i - 1];
			}
			//如果后两位能组成"1x"（x为任意数字）或者"2x"（x小于7），说明最后两位组成字母合法
			if ((s.charAt(i - 2) == '1') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[s.length()];
	}
}