class Solution {
     public boolean validPalindrome(String s) {
        return helper(s, 0, s.length() - 1, 0);
    }

    private boolean helper(String s, int i, int j, int times) {
        if (times > 1) return false;
        if (i >= j) return true;
        return s.charAt(i) != s.charAt(j) ?
                helper(s, i + 1, j, times + 1) || helper(s, i, j - 1, times + 1) : helper(s, i + 1, j - 1, times);
    }
}