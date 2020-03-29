//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(o ->o[0]));
        ArrayList<int[]> ints = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int n=i;
            int max=intervals[i][1];
            while (i<intervals.length-1&&max>=intervals[i+1][0])
                max=Math.max(max,intervals[++i][1]);
            ints.add(new int[]{intervals[n][0],max});
        }
        return ints.toArray(new int[ints.size()][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
