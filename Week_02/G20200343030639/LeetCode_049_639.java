class LeetCode_049_639 {
	public List<List<String>> groupAnagrams(String[] strs) {
		//判断参数是否为空
		if (strs.length == 0) return new ArrayList();
		Map<String, List> map = new HashMap<String, List>();
		//循环字符串数组
		for (String s : strs) {
			//将字符串转化为字符数组
			char[] ca = s.toCharArray();
			//将字符数组排序
			Arrays.sort(ca);
			//将排序后的结果作为Key
			String key = String.valueOf(ca);
			//如果map中不包含这个Key
			if (!map.containsKey(key)){
				//则map插入一条包含Key的记录
				map.put(key, new ArrayList());
			}
			//如果map中包含该Key,则将字符串作为该的value
			map.get(key).add(s);
		}
		return new ArrayList(map.values());
	}


	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(strs));
	}
}