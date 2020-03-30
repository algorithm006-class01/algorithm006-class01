package com.study.week07;

public class LeetCode_2_429 {
    /**
     * 数组相对排序
     * @param n
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] temp = new int[1001];
        for (int i : arr1) {
            temp[i]++;
        }
        int index = 0;
        for (int i : arr2) {
            while (temp[i] > 0) {
                arr1[index] = i;
                temp[i]--;
                index++;
            }
        }

        for (int i = 0; i < temp.length; i++) {
            while (temp[i] > 0) {
                arr1[index] = i;
                temp[i]--;
                index++;
            }
        }
        return arr1;
    }
}