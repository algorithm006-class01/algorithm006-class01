package com.study.week03;

import com.study.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Abner
 * @date 2020/3/1 21:15
 * @email songkd90@163.com
 * @description 股票最佳时机
 */
public class LeetCode_2_429 {
    /**
     * 解法一：暴力，计算所有可能性
     * @param prices
     * @return  运行结果超出时间限制
     */
    public int maxProfit(int[] prices) {
        return calculate(prices, 0);
    }

    private int calculate(int[] prices, int s) {
        // 递归终止条件
        if (s > prices.length) {
            return 0;
        }

        int max = 0;
        for (int i = s; i < prices.length; i++) {
            int maxprofit = 0;
            for (int j = i+1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    // 下潜
                    int profit = calculate(prices, j + 1) + prices[j] - prices[i];
                    if (profit > maxprofit) {
                        maxprofit = profit;
                    }
                }
            }

            if (maxprofit > max) {
                max = maxprofit;
            }
        }
        return max;
    }


    /**
     * 解法二：贪心算法，后一天的股价减前一天的股价，结果只加正数
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }
}
