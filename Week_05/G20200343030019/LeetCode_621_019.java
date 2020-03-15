class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char c: tasks) {
            arr[c - 'A'] ++;
        }
        Arrays.sort(arr);
        int max_val = arr[25] - 1;
        int all_space = max_val * n;
        for (int i = 24; i >= 0; i --) {
            all_space -= Math.min(arr[i], max_val);
        }
        return all_space > 0 ? tasks.length + all_space : tasks.length;
    }
}