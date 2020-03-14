package week5.decode_ways;

public class Solution {
    // a[n]=a[n-1]+a[n-2]   (1<26)
    // a[n]=a[n-1] (>26)
    public int numDecodings(String s) {
        if (s.length()==0) return 0;
        int[] sum = new int[s.length()+1];
        sum[0]=1;
        sum[1]=s.charAt(0)!='0'?1:0;
        for (int n=2;n<=s.length();n++){
            String t = s.substring(n-1,n);
            String pre = s.substring(n-2,n);
            if (Integer.valueOf(t)>0){
                sum[n]=sum[n]+sum[n-1];
            }
            if (Integer.valueOf(pre)>=10&&Integer.valueOf(pre)<27){
                sum[n]=sum[n]+sum[n-2];
            }
        }
        return sum[s.length()];
    }

    public static void main(String[] args) {
        String aaa = "226";
        Solution s = new Solution();
        System.out.println(s.numDecodings(aaa));
    }
}
