class Solution {
    public boolean validPalindrome(String s) {
        int low = 0;
        int hight = s.length() - 1;
        while (low < hight) {
            if (s.charAt(low) != s.charAt(hight)) {
                return isPalindrome(s, low, hight - 1) || isPalindrome(s, low + 1, hight);
            }
            low++;
            hight--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int low, int hight) {
        while (low < hight) {
            if (s.charAt(low) != s.charAt(hight)) {
                return false;
            }
            low++;
            hight--;
        }
        return true;
    }
}