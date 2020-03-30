/*
 * 191. Number of 1 Bits
 * 位1的个数
 */
public class LeetCode_191_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class Solution {
	    // you need to treat n as an unsigned value
	    public int hammingWeight(int n) {
	        int count = 0;
	        for( int i = 0; i < 32; i++ ) {
	        	if( ((n >> i) & 1) == 1 )
	        		count++;
	        }
	        return count;
	    }
	}
}
