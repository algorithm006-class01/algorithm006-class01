/*
 * 242. Valid Anagram
 * 有效的字母异位词
 * 
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false


 */
public class LeetCode_242_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
	    public boolean isAnagram(String s, String t) {
	    	if( s.length() != t.length() )
	    		return false;
	    	
	    	int[] a = new int[26];	    	
	    	for( int i = 0; i < s.length(); i++ ) {
	    		a[s.charAt(i)-'a']++;
	    		a[t.charAt(i)-'a']--;
	    	}
	    	for( int i : a ) {
	    		if(i > 0)
	    			return false;
	    	}
	    	return true;
	    }
	}
}
