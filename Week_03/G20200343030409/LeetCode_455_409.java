/*
    greedy

    time complexity: O(nlogn), space complexity: O(1)
*/
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); //both need to sort first, because we will compare one by one from beginning
        Arrays.sort(s);

        int i = 0;
        for (int cookies: s) {
            if (i < g.length && g[i] <= cookies) { //if it matches content, increment count
                i++;
            }
        }
        return i;
    }
}