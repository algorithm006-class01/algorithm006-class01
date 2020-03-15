class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() ==0) return word2 != null ? word2.length() : 0;
        if (word2 == null || word2.length() ==0) return word1 != null ? word1.length() : 0;
        int[] arr = new int[word2.length() + 1];
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        for (int i = 1; i <= w2.length; i ++) arr[i] = i;
        int pre = 0;
        int temp = 0;
        for (int i = 1; i <= w1.length; i ++) {
            pre = arr[0];
            arr[0] = i;
            for (int j = 1; j <= w2.length; j ++) {
                temp = arr[j];
                arr[j] = w1[i - 1] == w2[j - 1] ? pre : Math.min(Math.min(pre, arr[j]), arr[j - 1]) +  1;
                pre = temp;
            }
        }
        return arr[w2.length];
    }
}