class Solution {
    public int countSubstrings(String s) {
if (s == null || s.length() == 0)
			return 0;
		boolean[][] dp = new boolean[s.length()][s.length()];
		int res = 0;
		for (int j = 0; j < s.length(); j++) {
			for (int i = j; i >= 0; i--) {
				if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
					res++;
					dp[i][j] = true;
				}

			}
		}
		return res;
	}
    }