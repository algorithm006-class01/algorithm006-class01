package week5.task_scheduler;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        for (char a:tasks){
            if (map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else{
                map.put(a,1);
            }
            max=Math.max(map.get(a),max);
        }
        int time = (max-1)*(n+1);

        for (Character key:map.keySet()){
            int value = map.get(key);
            if (value==max){
                time=time+1;
            }
        }
        return Math.max(time,tasks.length);
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 50;
        Solution s = new Solution();
        System.out.println(s.leastInterval(tasks,n));
    }
}
