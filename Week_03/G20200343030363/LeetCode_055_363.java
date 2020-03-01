package cn.geek.week3;

/**
 *
 * 跳跃游戏
 * 
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月29日 17:14:00
 */
public class LeetCode_055_363 {

    /**
     * Can jump boolean.
     *
     * @param nums
     *            the nums
     * @return the boolean
     */
    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {

            // 如果当前位置超过了能到达的最远位置，返回false
            if (i > k) {
                return false;
            }
            k = Math.max(k, i + nums[i]);
            if (k > nums.length - 1) {
                break;
            }
        }
        return true;
    }
}
