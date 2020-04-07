public String preProcess(String s) {
    int n = s.length();
    if (n == 0) {
        return "^$";
    }
    String ret = "^";
    for (int i = 0; i < n; i++)
        ret += "#" + s.charAt(i);
    ret += "#$";
    return ret;
}

public String longestPalindrome(String s) {
    String T = preProcess(s);
    int n = T.length();
    int[] P = new int[n];
    int C = 0, R = 0;
    for (int i = 1; i < n - 1; i++) {
        int i_mirror = 2 * C - i;
        if (R > i) {
            P[i] = Math.min(R - i, P[i_mirror]);
        } else {
            P[i] = 0;
        }
        while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
            P[i]++;
        }
        if (i + P[i] > R) {
            C = i;
            R = i + P[i];
        }

    }

    int maxLen = 0;
    int centerIndex = 0;
    for (int i = 1; i < n - 1; i++) {
        if (P[i] > maxLen) {
            maxLen = P[i];
            centerIndex = i;
        }
    }
    int start = (centerIndex - maxLen) / 2; 
    return s.substring(start, start + maxLen);
}
