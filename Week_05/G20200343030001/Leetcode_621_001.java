package Week_05;

import java.util.Arrays;

public class Leetcode_621_001 {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] count = new int[26];

            for (int i = 0; i < tasks.length; i++) {
                count[tasks[i] - 'A']++;
            }

            Arrays.sort(count);
            int maxCount = 0;

            for (int i = 25; i >= 0; i--) {
                if(count[i] != count[25]){
                    break;
                }
                maxCount++;
            }

            return Math.max((count[25] - 1) * (n + 1) + maxCount , tasks.length);
        }
    }

}
