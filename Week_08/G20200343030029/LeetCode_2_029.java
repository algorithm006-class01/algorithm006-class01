class LeetCode_2_029{
	public String reverseStr(String s, int k) {
		char[] c = s.toCharArray();
		for(int i = 0; i < c.length; i += 2 * k) {
			int swap1 = i;
			int swap2 = Math.min(i + k - 1, c.length - 1);
			while(swap1 < swap2) {
				Character temp = c[swap1];
				c[swap1] = c[swap2];
				c[swap2] = temp;
				swap1++;
				swap2--;
			}
		}
		return new String(c);
	}
}