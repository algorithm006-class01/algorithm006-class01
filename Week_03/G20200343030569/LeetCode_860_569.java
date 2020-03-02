/*
 * 860. Lemonade Change
 * 柠檬水找零
 */
public class LeetCode_860_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = { 5,5,5,10,20 };
		LeetCode_860_569 main = new LeetCode_860_569();
		boolean result = main.new Solution().lemonadeChange(data);
		System.out.println( result );
	}

	class Solution {
	    public boolean lemonadeChange(int[] bills) {
	    	int five = 0;
	    	int ten = 0;	    	
	    	for( int bill: bills ) {
	    		if ( bill == 5 ) {
	    			five++;
	    		} else if( bill == 10 ) {
	    			if ( five-- <= 0 ) 
	    				return false;	    			
	    			ten++;
	    		}else {
	    			if ( five > 0 && ten > 0 ) {
	    				five--;
	    				ten--;
	    			} else if ( five >= 3 ) {
	    				five -= 3;
	    			} else 	{
	    				return false;
	    			}
	    		}
	    	}
	    	return true;
	    }
	}
}
