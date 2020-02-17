public class LeetCode_11_391 {
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int max = maxAreaDoubleCursor(nums);
        System.out.println(max);

    }

    /**
     * 暴力解法
     * 时间复杂度O(n^2)
     * @param height
     * @return
     */
    public static int maxAreaViolence(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }

    /**
     * 双指针：
     *  两侧夹逼移动最小板
     *  时间复杂度O(n^2)
     * @param height
     * @return
     */
    public static int maxAreaDoubleCursor(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            if (height[i] < height[j]) {
                max = Math.max(max, height[i] * (j - i));
                i++;
            } else {
                max = Math.max(max, height[j] * (j - i));
                j--;
            }

        }
        return max;
    }
}
