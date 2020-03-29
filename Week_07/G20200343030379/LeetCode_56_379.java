package G20200343030379;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例?2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 参考优秀题解：
 */
public class LeetCode_56_379 {

    public static void main(String[] args) {
        //十进制转二进制
        //String s = Integer.toBinaryString(-2147483648);
    }

    /**
     * 1、判空
     *
     * 2、排序
     *
     * 3、获取左右边界
     *
     * 4、遍历个数
     * 	4.1 下一个左边界小于等于当前右边界
     * 		4.1.1 下一个右边界 大于当前左边界
     * 			更新有边界
     *
     * 	4.2 下一个右边界大于当前右边界
     * 		4.2.1 添加当前左右边界
     * 			更下下一个左右边界
     *  5 记录左右边界值
     *
     *
     *  执行用时 : 7 ms , 在所有 Java 提交中击败了 86.96% 的用户
     *  内存消耗 : 41.7 MB , 在所有 Java 提交中击败了 54.96% 的用户
     *
     *  优秀题解：
     *      https://leetcode-cn.com/problems/merge-intervals/solution/pai-xu-yi-ci-sao-miao-zhu-xing-jie-shi-hao-li-jie-/
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> res=new ArrayList<>();
        if(intervals.length==0) return res.toArray(new int[intervals.length][]);

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });


        int length=intervals.length;
        int left=intervals[0][0];
        int right=intervals[0][1];

        for (int i = 1; i < length-1; i++) {
            if(intervals[i][0]<=right){
                if(intervals[i][1]>right){
                    right=intervals[i][1];
                }
            }else{
                res.add(new int[]{left,right});
                left=intervals[i][0];
                right=intervals[i][1];
            }

        }
        res.add(new int[]{left,right});

        return res.toArray(new int[res.size()][]);
    }
}