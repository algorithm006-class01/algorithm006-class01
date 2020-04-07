class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i += 2 * k) {
            int j = Math.min(i + k, arr.length) - 1;
            for (int x = i; j > x; x ++, j --) {
                char temp = arr[j];
                arr[j] = arr[x];
                arr[x] = temp;
            }
        }
        return new String(arr);
    }
}