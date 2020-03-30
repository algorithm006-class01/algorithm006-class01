
class LeetCode_192_505 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return new int[0][0];
        }

        int m = intervals.length;
        if (m == 0) {
            return new int[0][0];
        }
        int n = intervals[0].length;
        //对二维数组排序 根据区间左元素大小
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        //依次遍历数组 如果 第一个区间right<=第二个区间left证明两个相交
        int i = 0;
        //int[] 也能做泛型参数
        List<int[]> result = new ArrayList();
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            //从i开始往后查找 满足条件的所有的 
            while (i < intervals.length - 1 && right >= intervals[i+1][0]) {
                ++i;
                //更新右边left
                right = Math.max(right, intervals[i][1]);
            }
            //更新结果
            result.add(new int[]{left, right});
            ++i;
        }

        //学习转换方法     
        return result.toArray(new int[0][]);
    }
}
