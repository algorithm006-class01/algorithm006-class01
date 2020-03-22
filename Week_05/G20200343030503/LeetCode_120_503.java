/**
 * 	三角形的最小路径和
 *  DP
 *  a. 重复性(分治) problem(i,j) = min(sub(i+1,j),sub(i+1,j+1)) + a(i,j);
 *  b. 定义状态数组(状态数组是一维还是二维的) f[i,j]
 *  c. DP方程 f[i,j] = min(f[i+1,j],f[i+1,j+1]) + a[i,j];
 *
 *
 *
 */
/**
 *  DP
 *  a. 重复性(分治) problem(i,j) = min(sub(i+1,j),sub(i+1,j+1)) + a(i,j);
 *  b. 定义状态数组(状态数组是一维还是二维的) f[i,j]
 *  c. DP方程 f[i,j] = min(f[i+1,j],f[i+1,j+1]) + a[i,j];
 *
 */
class Solution {
    //动态规划
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] a = new int[triangle.size()+1];
        for (int i = triangle.size()-1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++ ) {
                a[j] = Math.min(a[j],a[j+1]) + triangle.get(i).get(j);;
            }
        }
        return a[0];
    }
    //递归
    int row;
    public int minimumTotal(List<List<Integer>> triangle) {
        row=triangle.size();
        return helper(0,0, triangle);
    }
    private int helper(int level, int c, List<List<Integer>> triangle){
        // System.out.println("helper: level="+ level+ " c=" + c);
        if (level==row-1){
            return triangle.get(level).get(c);
        }
        int left = helper(level+1, c, triangle);
        int right = helper(level+1, c+1, triangle);
        return Math.min(left, right) + triangle.get(level).get(c);
    }

}