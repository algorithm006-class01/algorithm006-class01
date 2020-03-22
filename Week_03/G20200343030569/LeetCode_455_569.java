import java.util.Arrays;

/*
 * 455. Assign Cookies
 */
public class LeetCode_455_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] g = { 1, 2, 3 };
		int[] s = { 3 };
		LeetCode_455_569 main = new LeetCode_455_569();
		int result = main.new Solution().findContentChildren(g, s);
		System.out.println( result );

	}

	class Solution {
	    public int findContentChildren(int[] g, int[] s) {
	    	int result = 0;
	    	Arrays.sort(g);
	    	Arrays.sort(s);
	    	for( int gi = 0, si = 0; gi < g.length && si < s.length; si++) {
	    		if ( g[gi] <= s[si] ) {
	    			gi++;
	    			result++;
	    		}
	    	}
	    	return result;
	    }
	}
}
