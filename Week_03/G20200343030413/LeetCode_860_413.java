package com.kidand.homework.week03;
/**
*
*  ██╗  ██╗██╗██████╗  █████╗ ███╗   ██╗██████╗
*  ██║ ██╔╝██║██╔══██╗██╔══██╗████╗  ██║██╔══██╗
*  █████╔╝ ██║██║  ██║███████║██╔██╗ ██║██║  ██║
*  ██╔═██╗ ██║██║  ██║██╔══██║██║╚██╗██║██║  ██║
*  ██║  ██╗██║██████╔╝██║  ██║██║ ╚████║██████╔╝
*  ╚═╝  ╚═╝╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝
*
* @description:LeetCode_860_413
* @author: Kidand
* @date: 2020/2/28 5:38 下午
* Copyright © 2019-Kidand.
*/
public class LeetCode_860_413 {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0,back=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5) {
                ++five;
            }
            if(bills[i]==10) {
                ++ten;
            }
            back=bills[i]-5;
            while(back>=10&&ten>0){
                back-=10;
                --ten;
            }
            while(back>=5&&five>0){
                back-=5;
                --five;
            }
            if(back>0) {
                return false;
            }
        }
        return true;
    }
}
