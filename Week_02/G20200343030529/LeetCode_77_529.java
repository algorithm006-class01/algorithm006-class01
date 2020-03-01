package com.leetcode.practices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode.77.组合
 * https://leetcode-cn.com/problems/combinations/
 */
public class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    /**
     * 此题属于组合问题，即C(n, k)。n为总数，k为组合数目。
     * 解决方案，采取递归方案，先确定位置一的数字，然后再递归确定下一位置的数字。
     * 当list中大小==k时，把结果添加支result中
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        helper(0, k, 1, n, new ArrayList<>());
        return result;
    }

    /**
     *  套用递归模版
     * @param level 递归层深度
     * @param max 组合数目
     * @param begin 起始位置（begin...n）
     * @param n 总数
     * @param list 产生的组合结果暂时缓存区
     */
    private void helper(int level, int max, int begin, int n, List<Integer> list) {
        //terminator
        if (list.size() == max) {
            result.add(new ArrayList<>(list));
            return;
        }

        //process current logic
        for (int i = begin; i <= n; i++) {
            list.add(i);//每个位置只能够是begin..n的数字
            helper(level + 1, max, i + 1, n, list);//下一位置的数字
            //drill down
            list.remove(list.size() - 1);//因为当前list.size == max, 所以要删除最后一个元素（回溯，撤销前一状态）
        }

        //reverse states;

    }

}
