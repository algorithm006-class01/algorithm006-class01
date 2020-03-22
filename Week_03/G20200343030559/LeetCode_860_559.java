package jc.demo.LeetCode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_860_559 {
    public static void main(String[] args) {
        LeetCode_860_559 l = new LeetCode_860_559();
        int[] bills = {5,5,10};
        boolean t = l.lemonadeChange(bills);
        System.out.println(t);
    }
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;
        if(bills.length>10000){
            return false;
        }
        //Map<Integer,Integer> cash = new HashMap<Integer, Integer>();
        //cash.put(5,0);
        //cash.put(10,0);
        boolean changeOver =false;
        if(bills[0]!=5){
            return false;
        }
        if(bills.length==1&&bills[0]==5){
            return true;
        }
        //经过特殊情况的处理，现在第一个人肯定给的是5元，且来买的人肯定多于1个人
        for(int i =0;i<bills.length;i++) {
            if (bills[i]==5){
                //cash.put(5,cash.get(5)+1);
                five+=1;
                changeOver=true;
            }
            else if(bills[i]==10){
                //cash.put(10,cash.get(10)+1);
                ten+=1;
                if(five>0){
                    //找5元，5元-1
                    //cash.put(5,cash.get(5)-1);
                    five-=1;
                    changeOver=true;
                }else {
                    changeOver=false;
                    break;
                }
            }
            else if(bills[i]==20){
                //1找1张10元1张5元
                if (five>0&&ten>0){
                    //cash.put(10,cash.get(10)-1);
                    ten-=1;
                    //cash.put(5,cash.get(5)-1);
                    five-=1;
                    changeOver=true;
                    continue;
                    //找3张5元
                }else if(ten==0&&five>=3){
                    //cash.put(5,cash.get(5)-3);
                    five-=3;
                    changeOver=true;
                    continue;
                }else {
                    changeOver=false;
                    break;
                }
            }

        }
        return changeOver;
    }

//leetcode submit region end(Prohibit modification and deletion)
}
