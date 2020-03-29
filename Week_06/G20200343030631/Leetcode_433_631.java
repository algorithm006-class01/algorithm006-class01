package com.dsx.fourhundred.thirty.three;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 解题思路: 优化version1的广度优先，改为双向bfs，每次只处理量少的那个set
 * 时间复杂度: O(n+m)
 * 空间复杂度: O(n+m)
 * 执行用时: 1 ms, 在所有 Java 提交中击败了71.52%的用户
 * 内存消耗: 37.5 MB, 在所有 Java 提交中击败了5.10%的用户
 * @Author: loe881@163.com
 * @Date: 2020/2/27
 */
public class Solution {
    public static void main(String[] args) {
        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String[] bank = new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        System.out.println(minMutation(start, end, bank));
    }

    public static int minMutation(String start, String end, String[] bank) {
        // 变化次数
        int result = 0;
        // 边界条件，start、end、bank任何一个为null，或者bank中不包含end
        if (null == start || null == end || null == bank
                || bank.length == 0 || !Arrays.asList(bank).contains(end)){
            return -1;
        }
        // 边界条件，如果start、end相等，不需要变化，直接返回0
        if (start.equalsIgnoreCase(end)){
            return 0;
        }
        HashSet<String> store = new HashSet<>(Arrays.asList(bank));
        char[] dict = new char[]{'A', 'C', 'G', 'T'};
        Queue<String> possibleChangeFromStart = new LinkedList<>();
        Queue<String> possibleChangeFromEnd = new LinkedList<>();
        possibleChangeFromStart.offer(start);
        possibleChangeFromEnd.offer(end);
        store.remove(start);
        store.remove(end);
        while (!possibleChangeFromStart.isEmpty() && !possibleChangeFromEnd.isEmpty()){
            // 每次循环，变化次数+1
            result++;

            if (possibleChangeFromStart.size() > possibleChangeFromEnd.size()){
                Queue<String> tmpQueue = possibleChangeFromStart;
                possibleChangeFromStart = possibleChangeFromEnd;
                possibleChangeFromEnd = tmpQueue;
            }
            // 当前次合法的变化列表，循环处理合法变化列表
            for (int i = possibleChangeFromStart.size(); i > 0; i--) {
                // 取出一个合法变化基因串，循环改变每一个位置的元素
                char[] tmpChars = possibleChangeFromStart.poll().toCharArray();
                for (int j = 0; j < tmpChars.length; j++) {
                    char oldChar = tmpChars[j];
                    // 每个元素位置可选择的变化有四个，逐个循环
                    for (int k = 0; k < 4; k++) {
                        tmpChars[j] = dict[k];
                        String newGeneChange = new String(tmpChars);
                        if (possibleChangeFromEnd.contains(newGeneChange)){
                            return result;
                        }else if (store.contains(newGeneChange)){ // 如果包含在基因库中，说明本次是合法的变化，从基因库移除本次变化，放入可变化队列中，继续下一次变化
                            store.remove(newGeneChange);
                            possibleChangeFromStart.offer(newGeneChange);
                        }
                    }
                    tmpChars[j] = oldChar;
                }
            }
        }

        return -1;
    }
}
