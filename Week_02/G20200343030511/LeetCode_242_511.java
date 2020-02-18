public class IsAnagram {
	
	  //解题。。。字母异位 长度一定相同  暴力
	 public boolean isAnagram(String s, String t) {
		 if(s.length()!=t.length()) return false;
		 char[] ss = s.toCharArray();
		 char[] tt =t.toCharArray();		 
		 Arrays.sort(ss);
		 Arrays.sort(tt);		 
		 return Arrays.equals(ss, tt);
	 }
	 
	 
	 public boolean isAnagram1(String s, String t) {
		 if(s.length()!=t.length()) return false;
		 char[] ss = s.toCharArray();
		 char[] tt = t.toCharArray();		 
		 int[] array = new int[26];		 
		 for (int i = 0; i < ss.length; i++) {
			  array[ss[i]-'a']++;
			  array[tt[i]-'a']--;
		}
		 for (int i = 0; i < array.length; i++) {
			if(array[i]!=0) return false;
		}		 		 		 
		 return true;
	 }