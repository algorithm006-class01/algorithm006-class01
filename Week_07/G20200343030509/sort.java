/**
 * Copyright (C), 2020-2020, 孙亮
 * FileName: quickSort
 * Author:   sunliang
 * Date:     2020/03/28 11:51
 * Description: 快速排序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode.week07;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 〈一句话功能简述〉<br> 
 * 〈排序〉
 *
 * @author sunliang
 * @create 2020/03/28
 * @since 1.0.0
 */
public class sort {
  public static void main(String[] args) {
    long startTime = System.nanoTime();

    int[] array = new int[]{26,13,5,7,2,55,34,32,234,23,3};

//    mergeSort(array, 0, array.length - 1);
    insertionSort(array);
    System.out.println(Arrays.toString(array));

    long endTime = System.nanoTime();
    System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");


  }

  // 快速排序
  public static void quickSort(int[] array, int begin, int end) {
    if (end < begin) return;
    int pivot = partition(array, begin, end);
    quickSort(array, begin, pivot -1);
    quickSort(array, pivot + 1, end);
  }

  private static int partition(int[] a, int begin, int end) {
    int pivot = end, counter = begin;
    for (int i = begin; i < end; i++) {
      if (a[i] < a[pivot]) {
        int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
        counter++;
      }
    }
    int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
    return counter;
  }

  // 归并排序
  public static void mergeSort(int[] array, int left, int right) {
    if (left >= right) return;
    int mid = (left + right) >> 1;

    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
  }

  private static void merge(int[] a, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left, j = mid + 1, k = 0;
    while (i <= mid && j <= right) {
      temp[k++] = a[i] < a[j] ? a[i++] : a[j++];
    }
    while (i <= mid) temp[k++] = a[i++];
    while (j<= right) temp[k++] = a[j++];
    System.arraycopy(temp, 0, a, left,right - left + 1);

//    for (int p = 0; p < temp.length; p++) {
//      a[left + p] = temp[p];
//    }
  }

  // 堆排序
  public static void heapSort(int[] array, int length) {
    PriorityQueue<Integer> heap = new PriorityQueue<>(length);

    for (int temp : array) {
      heap.add(temp);
    }

    for (int i = 0 ; i < length; i++) {
      array[i] = heap.remove();
    }
  }

  // 冒泡排序
  public static void bubbleSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - 1 - i; j++) {
        if (array[j] > array[j+1]) {
          int temp = array[j];
          array[j] = array[j+1];
          array[j+1] = temp;
        }
      }
    }
  }

  // 选择排序
  public static void selectionSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }
      int temp = array[i];
      array[i] = array[minIndex];
      array[minIndex] = temp;
    }
  }

  // 插入排序
  public static void insertionSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int preIndex = i -1;
      int current = array[i];
      while (preIndex >= 0 && array[preIndex] > current) {
        array[preIndex + 1] = array[preIndex];
        array[preIndex--] = current;
      }
    }
  }
}
