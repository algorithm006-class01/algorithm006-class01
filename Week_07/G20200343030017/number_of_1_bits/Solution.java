package week7.number_of_1_bits;

public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n!=0){
            count++;
            n&=(n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        int n=-3;
        Solution s = new Solution();
        System.out.println(s.hammingWeight(n));
    }
}
