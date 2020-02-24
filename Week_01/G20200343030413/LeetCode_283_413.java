package com.kidand.homework;
/**
*
*  ██╗  ██╗██╗██████╗  █████╗ ███╗   ██╗██████╗
*  ██║ ██╔╝██║██╔══██╗██╔══██╗████╗  ██║██╔══██╗
*  █████╔╝ ██║██║  ██║███████║██╔██╗ ██║██║  ██║
*  ██╔═██╗ ██║██║  ██║██╔══██║██║╚██╗██║██║  ██║
*  ██║  ██╗██║██████╔╝██║  ██║██║ ╚████║██████╔╝
*  ╚═╝  ╚═╝╚═╝╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝
*
* @description:LeetCode_283_413 移动零
* @author: Kidand
* @date: 2020/2/15 1:42 下午
* Copyright © 2019-Kidand. 
*/
public class LeetCode_283_413 {
    public void moveZeroes(int[] nums) {
        for(int i=0,count=0;i<nums.length;i++){
            if(nums[i] != 0){
                //执行替换操作
                if(count != i){
                    nums[count] = nums[i];
                    nums[i] = 0;
                }
                count++;
            }
        }
    }
}
