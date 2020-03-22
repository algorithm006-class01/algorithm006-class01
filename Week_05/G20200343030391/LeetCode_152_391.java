package G20200343030391;


public class LeetCode_152_391 {

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, -9, 4};
        int i = new LeetCode_152_391().maxProduct(nums);
        System.out.println(i);
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 存在负数 分别维护以i结尾的最大最小dp状态空间
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];
        int ans = nums[0];
        minDp[0] = nums[0];
        maxDp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //当前值为负数，交换最大最小值
            if (nums[i] < 0) {
                int temp = minDp[i - 1];
                minDp[i - 1] = maxDp[i - 1];
                maxDp[i - 1] = temp;
            }
            minDp[i] = Math.min(nums[i], minDp[i - 1] * nums[i]);
            maxDp[i] = Math.max(nums[i], maxDp[i - 1] * nums[i]);
            ans = Math.max(maxDp[i], ans);
        }
        return ans;
    }

}
