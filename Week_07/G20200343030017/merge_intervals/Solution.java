package week7.merge_intervals;

import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length==0){
            return new int[][]{};
        }
        TreeMap<Integer,int[]> map = new TreeMap<>(Comparator.naturalOrder());
        for (int n=0;n<intervals.length;n++){
            if (map.containsKey(intervals[n][0])){
                if (intervals[n][1]>map.get(intervals[n][0])[1]){
                    map.put(intervals[n][0],intervals[n]);
                }
            }else{
                map.put(intervals[n][0],intervals[n]);
            }
        }
        LinkedList<int[]> list = new LinkedList<>();
        for (Integer key:map.keySet()){
            list.addLast(map.get(key));
        }
        list.stream().forEach(p-> System.out.println(Arrays.toString(p)));
        int t =0;
        while (t+1<list.size()){
            if (list.get(t)[1]>=list.get(t+1)[0] && list.get(t)[1]<list.get(t+1)[1]){
                list.get(t)[1]=list.get(t+1)[1];
                list.remove(t+1);
            }else if(list.get(t)[1]>=list.get(t+1)[1]){
                list.remove(t+1);
            }else{
                t++;
            }
        }
        int[][] target = new int[list.size()][2];
        for (int n=0;n<list.size();n++){
            target[n][0]=list.get(n)[0];
            target[n][1]=list.get(n)[1];
        }
        return target;
    }

    public static void main(String[] args) {
        int[][] intervals={{2,3},{5,5},{2,2},{3,4},{3,4}};
        //int[][] intervals={{1,4},{2,3}};
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.merge(intervals)));
    }
}
