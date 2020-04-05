class Solution {
    public String reverseStr(String s, int k) {
        char[] res = s.toCharArray();
        int i = 0;
        while(i < res.length) {
            if(i + k > res.length - 1) {
                k = res.length - i;
            }
            for(int j = 0; j < k/2; j++) {
                char tmp = res[i + j];
                res[i + j] = res[i + k -1 -j];
                res[i + k -1 - j] = tmp;
            }
            i += k * 2;
        }
        return String.valueOf(res);
    }
}