class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      Map<String,List<String>> map = new HashMap();
		for (int i = 0; i < strs.length; i++) {
			char[] temp =strs[i].toCharArray();
			Arrays.sort(temp);
			String key = new String(temp);
			if(!map.containsKey(key)){
				List<String> l = new ArrayList<>();
				l.add(strs[i]);
				map.put(key, l);
			}else{
				map.get(key).add(strs[i]);
			}			
		}
		return new ArrayList(map.values());
    }
	
	
	// ±º‰ O(NK) ø’º‰O(NK)
	public List<List<String>> groupAnagrams1(String[] strs) {
		Map<String,List<String>> map = new HashMap();
		int[] count =new int[26];
		for (int i = 0; i < strs.length; i++) {
			char[] temp = strs[i].toCharArray();
			Arrays.fill(count, 0);
			for (int j = 0; j < temp.length; j++) {
				count[temp[j]-'a']++;
			}
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < count.length; j++) {
				sb.append("#");
				sb.append(count[j]);
			}
			String key = sb.toString();
			if(!map.containsKey(key)){
				List l = new ArrayList();
				l.add(strs[i]);
				map.put(key, l);
			}else{
				map.get(key).add(strs[i]);
			}		
		}
		return new ArrayList(map.values());
	}
}