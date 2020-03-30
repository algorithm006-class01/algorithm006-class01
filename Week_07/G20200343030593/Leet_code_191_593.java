public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bits=0;
        for(int i=0;i<32;i++){
            if((n&1)!=0){
                bits++;
            }
            n>>=1;
        }
        return bits;
    }
}

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bits=0;
        while(n!=0){
            bits++;
            n&=n-1;
        }
        return bits;
    }
}