package secondWork;

import java.util.*;
//还是求助于letcode上面的解法
public class work590 {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, ArrayList<Object>> map=new HashMap<String, ArrayList<Object>>();
		for(String s:strs){
			char[] ch=s.toCharArray();
			Arrays.sort(ch);
			String key=String.valueOf(ch);
			if(!map.containsKey(key))    map.put(key,new ArrayList<Object>());
			map.get(key).add(s);
		}
		return new ArrayList(map.values());
	}
}

