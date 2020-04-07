package week08;

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
		String s = "12";
		int result = new LeetCode_91_569().new Solution().numDecodings(s);
		System.out.println( result );
	}
	
	/*
	 * 自右至左
	 * 定义状态数组： dp[i] 代表从第i位到最后的字串的解码方法
	 * dp方程：
	 * 		如果s[i]=0, dp[i]=0
	 * 		如果s[i]+s[i+1] <= 26, dp[i] = dp[i+1]+dp[i+2]
	 * 		如果s[i]+s[i+1] > 26, dp[i] = dp[i+1]
	 * 
	 */
	class Solution1 {
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
	
	//状态定义:
	//  dp[i] 代表s[0..i]总共解码个数
	//状态方程:
	//  if s[i] = 0 
    //      if s[i-1] = 1 || 2
	//           dp[i] = dp[i-2]
	//      else
	//           return 0;
	//  if s[i] != 0
	//      if  s[i-1,i] <= 26  &&  s[i-1,i] > 10 
	//           dp[i] = dp[i-1] + dp[i-2]
	//      else s[i-1,i] < 10 || s[i-1,i] > 26
	//           dp[i] = dp[i-1]
	
	class Solution {
	    public int numDecodings(String s) {
	    	int n = s.length();
	    	if( n <= 0)
	    		return 0;
	    	
	    	int[] dp = new int[n+1];
	    	dp[0] = 1;
	    	dp[1] = s.charAt(0) != '0' ? 1 : 0;
	    	
	    	for( int i = 1; i < s.length(); i++ ) {
	    		if ( s.charAt(i) == '0') {
	    			if( s.charAt(i-1) == '1' || s.charAt(i-1) == '2' ) {
	    				dp[i+1] = dp[i-1];
	    			}else {
	    				return 0;
	    			}
	    		} else if (Integer.parseInt(s.substring(i-1,i+1)) <= 26 
	    					&& Integer.parseInt(s.substring(i-1,i+1)) > 10 ) {
	    			dp[i+1] = dp[i] + dp[i-1];
	    		} else  {
	    			dp[i+1] = dp[i];
	    		}
	    	}
	    	return dp[n];
	    }
	}
}
