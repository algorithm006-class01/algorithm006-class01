
public class LeetCode_190_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class Solution {
	    // you need treat n as an unsigned value
	    public int reverseBits(int n) {
	        int r = 0;
	        for( int i = 0; i < 32; i-- ) {
	        	r += (n&1) << (31-i);
	        	n = n >> 1;
	        }
	        return r;
	    }
	}
}
