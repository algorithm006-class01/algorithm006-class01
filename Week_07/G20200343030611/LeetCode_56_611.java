package datast.sort;

import java.util.Arrays;
import java.util.LinkedList;

public class LeetCode_56_611 {

    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) return intervals;
            Interval[] intervalArray = new Interval[intervals.length];
            for (int i = 0; i < intervals.length; i++) {
                intervalArray[i] = new Interval(intervals[i]);
            }
            Arrays.sort(intervalArray);
            LinkedList<int[]> stack = new LinkedList<>();
            stack.push(intervalArray[0].arr);
            for (int i = 1; i < intervalArray.length; i++) {
                if (intervalArray[i].arr[0] <= stack.peek()[1]) {
                    int[] arr = stack.pop();
                    arr[1] = Math.max(arr[1], intervalArray[i].arr[1]);
                    stack.push(arr);
                } else {
                    stack.push(intervalArray[i].arr);
                }
            }
            return stack.toArray(new int[0][0]);
        }

        class Interval implements Comparable<Interval> {
            Integer start;
            int[] arr;

            Interval(int[] arr) {
                this.arr = arr;
                start = arr[0];
            }

            @Override
            public int compareTo(Interval o) {
                return this.start.compareTo(o.start);
            }
        }
    }
}
