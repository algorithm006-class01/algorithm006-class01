import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 49. Group Anagrams
 * 字母异位词分组
 */
public class LeetCode_49_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		LeetCode_49_569 main = new LeetCode_49_569();
		List<List<String>> result = main.new Solution().groupAnagrams(strs);
		for ( List<String> group: result ) {
			System.out.println(Arrays.toString(group.toArray()));
		}
	}

	class Solution {
	    public List<List<String>> groupAnagrams(String[] strs) {
	    	Map<String, List> anaMap = new HashMap<String, List>();
	    	for ( String s: strs ) {
	    		char[] t = s.toCharArray();
	    		Arrays.sort(t);
	    		String key = new String(t);
	    		if ( !anaMap.containsKey(key) ) {
	    			anaMap.put(key, new ArrayList() );
	    		}
	    		anaMap.get(key).add(s);	    		
	    	}
	    	
	    	return new ArrayList( anaMap.values() );
	    }
	}
}
