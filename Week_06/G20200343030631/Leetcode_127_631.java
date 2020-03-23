package com.dsx.hundred.twenty.seven;

import java.util.*;

/**
 * 解题思路: 双向bfs方式查找，从结尾与开始同时开始，每轮循环只处理变化队列小的这一组
 * 超过leetcode执行时间限制
 * 时间复杂度:
 * 空间复杂度:
 * 执行用时:
 * 内存消耗:
 *
 * @Author: loe881@163.com
 * @Date: 2020/3/22
 */
public class Solution {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(ladderLength(beginWord, endWord, new ArrayList<>(Arrays.asList(wordList))));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 1;
        // 边界判断
        if (null == beginWord || null == endWord || null == wordList
                || wordList.size() == 0 || !wordList.contains(endWord)) {
            return 0;
        }

        if (beginWord.equals(endWord)) {
            return 0;
        }

        // 字母字典表
        char[] chars = new char[26];
        generateCharDic(chars);
        Queue<String> fromStartladderTemp = new LinkedList<>();
        Queue<String> fromEndladderTemp = new LinkedList<>();
        // 保存已访问的单词
        Set<String> visited = new HashSet<>();
        fromStartladderTemp.offer(beginWord);
        fromEndladderTemp.offer(endWord);
        while (!fromStartladderTemp.isEmpty() && !fromEndladderTemp.isEmpty()) {
            if (fromStartladderTemp.size() > fromEndladderTemp.size()) {
                Queue<String> tmpQueue = fromStartladderTemp;
                fromStartladderTemp = fromEndladderTemp;
                fromEndladderTemp = tmpQueue;
            }
            int fromStartladderTempSize = fromStartladderTemp.size();
            for (int i = 0; i < fromStartladderTempSize; i++) {
                char[] tmpChars = fromStartladderTemp.poll().toCharArray();
                for (int k = 0; k < tmpChars.length; k++) {
                    char oldCharAtI = tmpChars[k];
                    for (char aChar : chars) {
                        tmpChars[k] = aChar;
                        String tmpResult = new String(tmpChars);
                        if (fromEndladderTemp.contains(tmpResult)) {
                            return result + 1;
                        } else if (!visited.contains(tmpResult) && wordList.contains(tmpResult)) {
                            visited.add(tmpResult);
                            System.out.println(result + "||" + tmpResult);
                            fromStartladderTemp.offer(tmpResult);
                        }
                    }
                    tmpChars[k] = oldCharAtI;
                }
            }
            result++;
        }
        return 0;
    }

    private static void generateCharDic(char[] chars) {
        for (int j = 97; ; j++) {
            chars[j - 97] = (char) j;
            if ('z' == (char) j) {
                break;
            }
        }
    }
}
