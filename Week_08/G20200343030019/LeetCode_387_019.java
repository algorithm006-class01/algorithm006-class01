class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[256];
        for (char c: s.toCharArray()) {
            arr[c] ++;
        }
        int index = 0;
        for (char c: s.toCharArray()) {
            if (arr[c] == 1) {
                return index;
            }
            index ++;
        }
        return -1;
    }
}