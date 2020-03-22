class Solution {
    Set<String> codeSet = new HashSet<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
            "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26"));
    private int res = 0;

    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = codeSet.contains(s.substring(0, 1)) ? 1 : 0;

        for (int i = 2; i <= len; i++) {
            int currSolutionCount = 0;
            if (codeSet.contains(s.substring(i - 1, i))) {
                currSolutionCount += dp[i - 1];
            }
            if (codeSet.contains(s.substring(i - 2, i))) {
                currSolutionCount += dp[i - 2];
            }
            dp[i] = currSolutionCount;
        }

        return dp[len];
    }
}