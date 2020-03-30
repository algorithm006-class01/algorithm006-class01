package Alogrithm0308;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution56 {

		public int[][] merge(int[][] arr) {
			Arrays.parallelSort(arr, Comparator.comparingInt(x -> x[0]));

			LinkedList<int[]> list = new LinkedList<>();
			for (int i = 0; i < arr.length; i++) {
				if (list.size() == 0 || list.getLast()[1] < arr[i][0]) {
					list.add(arr[i]);//集合为空，或不满足条件，向后新增
				} else {//满足条件，集合最后元素的end=最大值
					list.getLast()[1] = Math.max(list.getLast()[1], arr[i][1]);
				}
			}
			int[][] res = new int[list.size()][2];//生成结果数组
			int index = 0;
			while (!list.isEmpty()) {//遍历集合
				res[index++] = list.removeFirst();//删除集合首元素
			}
			return res;
		}
	}

