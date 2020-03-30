package com.dsx.thirty.six;

import java.util.HashMap;
import java.util.Map;

/**
 * 解题思路: 循环一遍，记录已存在数字到map中，判断是否重复即可；
 * 时间复杂度: O(1)
 * 空间复杂度: O(1)
 * 执行用时: 5 ms, 在所有 Java 提交中击败了38.52%的用户
 * 内存消耗: 41.2 MB, 在所有 Java 提交中击败了96.34%的用户
 *
 * @Author: loe881@163.com
 * @Date: 2020/3/22
 */
public class Solution {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        if (null == board || board.length == 0 || board[0].length == 0) {
            return false;
        }

        Map<Integer, Map<Character, Integer>> rowRecords = new HashMap<>();
        Map<Integer, Map<Character, Integer>> colRecords = new HashMap<>();
        Map<Integer, Map<Character, Integer>> boxRecords = new HashMap<>();
        int rowCount = board.length;
        int colCount = board[0].length;

        for (int row = 0; row < rowCount; row++) {
            Map<Character, Integer> currentRowRecord = getCurrentRecordMap(rowRecords, row);
            for (int col = 0; col < colCount; col++) {
                char current = board[row][col];
                Map<Character, Integer> currentColRecord = getCurrentRecordMap(colRecords, col);
                if (!('.' == current)){
                    int boxIndex = (row / 3 ) * 3 + col / 3;
                    Map<Character, Integer> currentBoxRecord = getCurrentRecordMap(boxRecords, boxIndex);
                    if (currentBoxRecord.containsKey(current) || currentColRecord.containsKey(current)
                            || currentRowRecord.containsKey(current)){
                        return false;
                    }else {
                        currentRowRecord.put(current, 1);
                        currentBoxRecord.put(current, 1);
                        currentColRecord.put(current, 1);
                    }
                }
            }
        }
        return true;
    }

    private static Map<Character, Integer> getCurrentRecordMap(Map<Integer, Map<Character, Integer>> recordMaps, int index) {
        Map<Character, Integer> recordMap = recordMaps.computeIfAbsent(index, k -> new HashMap<>());
        return recordMap;
    }
}
