
/*
 * 91. Decode Ways
 * 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:

输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。


 */
public class LeetCode_91_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "12031";
		int result = new LeetCode_91_569().new Solution().numDecodings(s);
		System.out.println( result );
	}

	/*
	 * 自底而上
	 * 分治：problem[i] = subproblem[i+1] + subproblem[i+2](i+2如果该双字符不大于26，则i+2=0)
	 * 状态数组： dp[n+1]
	 * dp方程：
	 * 		如果s[i]=0, dp[i]=0
	 * 		如果s[i]+s[i+1] <= 26, dp[i] = dp[i+1]+dp[i+2]
	 * 		如果s[i]+s[i+1] > 26, dp[i] = dp[i+1]
	 * 
	 */
	class Solution {
	    public int numDecodings(String s) {
	    	int n = s.length();
	    	if( n <= 0)
	    		return 0;
	    	
	    	int[] dp = new int[n+1];
	    	dp[n] = 1;
	    	dp[n-1] = s.charAt(n-1) != '0' ? 1 : 0;
	    	
	    	for( int i = n-2; i >= 0; i-- ) {
	    		if ( s.charAt(i) == '0') {
	    			dp[i] = 0;
	    		} else if (Integer.parseInt(s.substring(i,i+2)) <= 26 ) {
	    			dp[i] = dp[i+1] + dp[i+2];
	    		} else  {
	    			dp[i] = dp[i+1];
	    		}
	    	}
	    	return dp[0];
	    }
	}
}
