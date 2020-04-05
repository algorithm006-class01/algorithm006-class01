class Solution {
    public String reverseWords(String s) {
        if (s.length() == 0) return s;
        String out = "";
        int index = s.length();
        for (int i = s.length() - 1; i >= 0; i --) {
            if (s.charAt(i) == ' ') {
                if (index - i > 1) {
                    out += " " + s.substring(i + 1, index);
                }
                index = i;
            }
        }
        if (index - 0 >= 1) {
            out += " " + s.substring(0, index);
        }
        return out.trim();
    }
}