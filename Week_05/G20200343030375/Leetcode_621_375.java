package G20200343030375;

public class Leetcode_621_375 {
    public int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        int max = 0;
        int maxCount = 0;
        for(char task : tasks) {
            c[task - 'A']++;
            if(max == c[task - 'A']) {
                maxCount++;
            }
            else if(max < c[task - 'A']) {
                max = c[task - 'A'];
                maxCount = 1;
            }
        }

        int pCount = max - 1;
        int pLength = n - (maxCount - 1);
        int cp = pCount * pLength;
        int availableTasks = tasks.length - max * maxCount;
        int i = Math.max(0, cp - availableTasks);

        return tasks.length + i;
    }
}
