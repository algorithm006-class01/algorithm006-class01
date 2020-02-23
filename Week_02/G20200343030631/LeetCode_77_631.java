package com.dsx.seventy.seven;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 解题思路: 基于数学组合思路，一个个数字回溯穷举
 * 时间复杂度:
 * 空间复杂度:
 * 执行用时: 33 ms, 在所有 Java 提交中击败了32.33%的用户
 * 内存消耗: 44.4 MB, 在所有 Java 提交中击败了5.02%的用户
 * @Author: loe881@163.com
 * @Date: 2020/2/23
 */
public class Version1 {
    public static void main(String[] args) {
        List<List<Integer>> result = combine(4, 2);
        for (List<Integer> integers : result) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList();
        combineInternal(1, result, n, k, new LinkedList<Integer>());
        return result;
    }

    private static void combineInternal(int first, List<List<Integer>> result, int n, int k, LinkedList<Integer> current) {
        if (current.size() == k){
            result.add(new LinkedList<>(current));
        }
        for (int i = first; i <= n; i++) {
            current.add(i);
            combineInternal(i + 1, result, n, k, current);
            current.removeLast();
        }
    }
}
