class Solution {
    public String minWindow(String s, String t) {
		int[] window = new int[128];
		int[] need = new int[128];
		for (int i = 0; i < t.length(); i++) {
			need[t.charAt(i)]++;
		}
		int l = 0, r = 0, count = 0;
		int minlength = s.length() + 1;
		String result="";
		while (r < s.length()) {
			char ch = s.charAt(r);
			window[ch]++;
			if (need[ch] > 0&&need[ch]>=window[ch]) {				
				count++;
			}
			while (count == t.length()) {
				ch = s.charAt(l);
				if (need[ch] > 0 &&need[ch]>=window[ch]) {
					count--;
				}
				if (r - l + 1 < minlength) {
					minlength = r - l + 1;
					result = s.substring(l,r+1);
				}
				window[ch]--;
				l++;
			}
			r++;
		}

		return result;

	}
}