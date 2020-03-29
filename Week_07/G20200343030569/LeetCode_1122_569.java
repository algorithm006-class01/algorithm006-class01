/*
 * 1122. Relative Sort Array
 * 数组的相对排序
 */
public class LeetCode_1122_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	class Solution {
	    public int[] relativeSortArray(int[] arr1, int[] arr2) {
	    	int[] ca = new int[1001];
	    	int[] ra = new int[arr1.length];
	    	int ri = 0;
	    	for( int i : arr1 ) {
	    		ca[i]++;
	    	}
	    	for( int j : arr2 ) {
	    		while( ca[j]-- > 0 ) {
	    			ra[ri++] = j;
	    		}
	    	}
	    	for( int i = 0; i < 1000; i++ ) {
	    		while( ca[i]-- > 0 ) {
	    			ra[ri++] = i;
	    		}
	    	}
	    	return ra;
	    }
	}
}
