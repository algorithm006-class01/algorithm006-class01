class LeetCode_1_029{
	/**字符串第一个唯一字符  方法1(暴力求解法：时间复杂度O(n^2))  方法2：放入map中，时间复杂度O(n), 空间复杂度O(n) **/
	public int firstUniqChar(String s) {
		if(s.length() == 0) {
			return -1;
		}

		char[] charArray = s.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for(char c : charArray) {
			if(!map.containsKey(c)) {
				map.put(c,1);
			}else{
				map.put(c, map.get(c) + 1);
			}
		}

		for(int i = 0; i < charArray.length; i++){
			if(map.get(charArray[i]) == 1) {
				return i;
			}
		}

		return -1;
	}
}
