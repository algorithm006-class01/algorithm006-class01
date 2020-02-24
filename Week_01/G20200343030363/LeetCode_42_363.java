package cn.geet.week1;

/**
 *
 * 接雨水
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月16日 11:33:00
 *
 */
public class LeetCode_42_363 {

    /**
     * Trap int. 按列求和, 暴力解法 O(n^2)
     *
     * @param height
     *            the height
     * @return the int
     */
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {

            int max_left = 0;
            int max_right = 0;

            // 找出左边最高
            for (int j = 0; j < i; j++) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }

            // 找出右边最高
            for (int k = i + 1; k < height.length; k++) {
                if (height[k] > max_right) {
                    max_right = height[k];
                }
            }
            int min = Math.min(max_left, max_right);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
}
