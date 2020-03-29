package leetcode.Week01;

public class LeetCode_11_535 {

    /***
     *给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     *
     *
     *
     * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     *
     *  
     *
     * 示例:
     *
     * 输入: [1,8,6,2,5,4,8,3,7]
     * 输出: 49
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     * 思路1：暴力法    time : o(n^2)
     * 思路2：双指针法  time : o(n)
     */

    public static int maxArea1(int[] height) {
        /**1.排除掉i * i*/
        int maxAreas = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i],height[j]);
                maxAreas = Math.max(area,maxAreas);
            }
        }
        return maxAreas;
    }

    public static int maxArea2(int[] height) {
        int maxAreas = 0;
        int p1 = 0;                  /**p1表示头指针*/
        int p2 = height.length - 1;  /**p2表示尾指针*/
        while (p1 < p2){
            int minHeight = height[p1] <= height[p2] ? height[p1++] : height[p2--];
            int area = (p2 - p1 + 1) * minHeight;  /**为何加1：数组下标从0开始，坐标从1开始*/
            maxAreas = Math.max(maxAreas,area);
        }
        return maxAreas;
    }

    public static void main(String[] args) {
        int[] A = {1,8,6,2,5,4,8,3,7};
        System.out.println("最大的面积为：" + maxArea2(A));
    }
}
