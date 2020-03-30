import java.util.Arrays;
import java.util.Comparator;

/*
 * 56. Merge Intervals
 * 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

 */
public class LeetCode_56_569 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] ar =  { {2,6},{8,10},{15,18},{1,3} };
		new LeetCode_56_569().new Solution().merge(ar);
	}

	class Solution {
	    public int[][] merge(int[][] intervals) {
	    	if( intervals.length <= 1 )
	    		return intervals;
	    	 Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
	         int length = 1;
	         for (int i = 1; i < intervals.length; i++ ) {
	             if (intervals[length-1][1] < intervals[i][0])
	            	 intervals[length++] = intervals[i];
	             else
	            	 intervals[length-1][1] = Math.max(intervals[length-1][1], intervals[i][1]);
	         }
	         int[][] res = new int[length][];
	         System.arraycopy(intervals, 0, res, 0, length);
	         return res;
	    }
	}
}
