package G20200343030391;

public class LeetCode_45_391 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int b = new LeetCode_45_391().jump(nums);
        System.out.println(b);
    }

    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //最大跳跃位置
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                //更新边界
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
