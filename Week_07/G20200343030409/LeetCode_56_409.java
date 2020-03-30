/*
    time complexity: O(nlogn), space complexity: O(n)
 */
class Solution {
    public int[][] merge(int intervals[][]) {
        if(intervals == null || intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, (o1,o2)->o1[0]-o2[0]);


        int first[] = intervals[0];
        int start = first[0];
        int end = first[1];

        List<int[]> ans  = new ArrayList<>();

        for(int interval[]: intervals) {
            if(end >= interval[0]) {
                end = Math.max(end, interval[1]);
            } else {
                ans.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        ans.add(new int[]{start, end});



        return ans.toArray(new int[ans.size()][]);
    }
}