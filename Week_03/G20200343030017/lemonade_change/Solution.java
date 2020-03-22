package week3.lemonade_change;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (bills[0]!=5){
            return false;
        }
        int w5=1;
        int w10=0;
        for (int n=1;n<bills.length;n++){
            if (bills[n] == 5){
                w5++;
            }else if(bills[n] == 10){
                if (w5>=1){
                    w10++;
                    w5--;
                }else{
                    return false;
                }
            }else{
                if (w5>=1&&w10>=1){
                    w5--;
                    w10--;
                    continue;
                }else if(w5>=3) {
                    w5=w5-3;
                    continue;
                }else{
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] bills={5,5,5,10,20};
        Solution s = new Solution();
        System.out.println(s.lemonadeChange(bills));
    }
}
