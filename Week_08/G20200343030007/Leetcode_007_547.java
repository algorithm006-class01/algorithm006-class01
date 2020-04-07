class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int i = 0;
        while(i<arr.length){
            if(i+k>arr.length){
                k = arr.length-i;
            }
            for(int j=0;j<k/2;j++){
                char tmp = arr[i+j];
                arr[i+j] = arr[i+k-1-j];
                arr[i+k-1-j] = tmp;
            }
            i += 2*k;
        }
        return String.valueOf(arr);
    }
}
