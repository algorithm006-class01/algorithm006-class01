class Solution {
    public int longestValidParentheses(String s) {
        int[] arr = new int[s.length()];
        int right = 0;
        int max = 0;
        int cur = 0;
        for (int index = 1; index < s.length(); index ++) {
            if (s.charAt(index) == ')') {
                if (s.charAt(index - 1) == '(') {
                    arr[index] = 2 + (index > 1 ? arr[index - 2] : 0);
                } else if (index - 1 - arr[index - 1] >= 0 && s.charAt(index - 1 - arr[index - 1]) == '(') {
                    arr[index] = 2 + arr[index - 1] + (index - 2 - arr[index - 1] > 0 ? arr[index - 2 - arr[index - 1]] : 0);
                }
                max = Math.max(max, arr[index]);
            }
        }
        return max;
    }
}