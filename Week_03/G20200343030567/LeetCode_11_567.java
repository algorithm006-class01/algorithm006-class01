package com.aizain.jhome.computer.data.list;

/**
 * MaxArea
 * 11. 盛最多水的容器
 * <p>
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例：
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zain
 * @date 2020/2/28
 */
public class MaxArea {

    /**
     * 审题：
     * 1 非负整数
     * 2 n>=2
     * <p>
     * 思路：
     * 1 暴力：两层循环，找出最大的
     * 2 左右夹逼，移动矮的指针
     * <p>
     * 反馈：
     * 1 中文站题解
     * 2 国际站题解
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        // return directlySolution(height);
        // return squeezeSolution(height);
        // return squeezeFastSolution(height);
        return squeezeZoomSolution(height);
    }

    /**
     * 左右夹逼计算急速版，国际站大佬提供
     *
     * @param height
     * @return
     */
    private int squeezeZoomSolution(int[] height) {
        int water = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            water = Math.max(water, h * (j - i));
            // 提速关键，找到下一个更长的
            while (height[i] <= h && i < j) i++;
            while (height[j] <= h && i < j) j--;
        }
        return water;
    }

    /**
     * 左右夹逼计算快速版
     *
     * @param height
     * @return
     */
    private int squeezeFastSolution(int[] height) {
        int maxArea = 0;
        int head = 0;
        int tail = height.length - 1;
        while (head < tail) {
            int hh = height[head];
            int th = height[tail];
            int thisArea;
            // 提速关键1，减少逻辑判断次数
            if (hh < th) {
                thisArea = (tail - head) * hh;
                head++;
            } else {
                thisArea = (tail - head) * th;
                tail--;
            }
            // 提速关键2，减少赋值次数
            if (thisArea > maxArea) {
                maxArea = thisArea;
            }
        }
        return maxArea;
    }

    /**
     * 左右夹逼计算，移动矮的指针
     * <p>
     * 执行用时 : 4 ms, 在所有 Java 提交中击败了 75.11% 的用户（第一次貌似会慢一些）
     * 内存消耗 : 41.2 MB, 在所有 Java 提交中击败了 5.05% 的用户
     *
     * @param height
     * @return
     */
    private int squeezeSolution(int[] height) {
        int max = 0;
        int head = 0;
        int tail = height.length - 1;
        while (head < tail) {
            max = Math.max(max, (tail - head) * Math.min(height[head], height[tail]));
            if (height[head] < height[tail]) {
                head++;
            } else {
                tail--;
            }
        }
        return max;
    }

    /**
     * 暴力法求解
     * i,j两层循环要写熟练
     * <p>
     * 执行用时 : 481 ms, 在所有 Java 提交中击败了 7.41% 的用户
     * 内存消耗 : 41.5 MB, 在所有 Java 提交中击败了 5.05% 的用户
     *
     * @param height
     * @return
     */
    private int directlySolution(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }

}
