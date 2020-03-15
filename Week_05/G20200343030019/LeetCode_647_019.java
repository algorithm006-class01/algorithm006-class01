class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() <= 0) return 0;
        int[] arr = new int[s.length()];
        char[] carr = s.toCharArray();
        arr[0] = 1;
        for (int i = 1; i < s.length(); i ++) {
            arr[i] = 1 + arr[i - 1];
            for (int j = 0; j < i; j ++) {
                int lo = j, hi = i;
                while (lo < hi) {
                    if (carr[lo] == carr[hi]) {
                        lo ++; hi --;
                    } else {
                        break;
                    }
                }
                if (lo >= hi) arr[i] += 1;
            }
        }
        return arr[arr.length - 1];
    }
}