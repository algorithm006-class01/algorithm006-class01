package week08;

/*
 * 8. String to Integer (atoi)
 * 字符串转换整数 (atoi)
 */
public class LeetCode_8_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = " ";
		System.out.println( new  LeetCode_8_569().new Solution().myAtoi(str) );
	}

	class Solution {
	    public int myAtoi(String str) {
	    	if( str.length() <= 0 )
	    		return 0;
	    	int idx = 0;
	    	int sign = 1; 
	    	int result = 0;
	    	while( idx < str.length() && str.charAt(idx) == ' ' )
	    		idx++;	    	
	    	if( idx < str.length() && (str.charAt(idx) == '+' || str.charAt(idx) == '-') ){
	            sign = str.charAt(idx) == '+' ? 1 : -1;
	            idx++;
	        }
	    	while ( idx < str.length() ) {
	    		int digit = str.charAt(idx) - '0';
	            if ( digit < 0 || digit > 9 ) 
	            	break;
	            if (result > (Integer.MAX_VALUE - digit) / 10) {
	                 return  (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
	            }
	            result = result * 10 + digit;
	            idx++;
	         }
	    	return result * sign;

	    }
	}
}
