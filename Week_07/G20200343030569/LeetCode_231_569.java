/*
 * 231. Power of Two
 *  2的幂
 */
public class LeetCode_231_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
	    public boolean isPowerOfTwo(int n) {
	    	return n > 0 && ((n & (n-1)) == 0);
	    }
	}
}
