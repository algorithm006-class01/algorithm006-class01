package com.study.week03;

import com.study.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Abner
 * @date 2020/3/3 20:25
 * @email songkd90@163.com
 * @description 柠檬水找零
 *
 */
public class LeetCode_1_429 {

    // 1、暴力解法， 情景模拟
    // 记录手中5美元和10美元的数量
    // 找零后相应减去，20美元则优先找零10美元+5美元
    public boolean lemonChange(int[] bills) {
        // 初始时5美元与10美元数量为0
        int five = 0;
        int ten = 0;

        // 遍历购买单
        for (int bill : bills) {
            // 如果是5美元，无需找零5美元数量增1
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                // 如果顾客给10美元，则要找零五美元，看数量是否足够
                if (five == 0) {
                    return false;
                }
                // 找零，5美元数量少1，10美元增加了1
                five--;
                ten++;
            } else {
                // 20美元的情况
                // 优先找零10美元
                if (ten > 0 && five > 0) {
                    five--;
                    ten--;
                } else if(five >= 3) {
                    // 假如有3张五美元
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}


