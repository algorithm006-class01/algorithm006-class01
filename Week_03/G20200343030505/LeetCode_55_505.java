class LeetCode_55_505 {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }

        int k = 0;//k表示目前为止能走到的最大位置
        //每遍历一个i元素，计算以当前位置出发能走到的最远位置
        //如果i>k，表示之前能到的最远位置小于i 遍历结束
        for (int i=0;i<nums.length;++i) {
            if (i > k) {
                return false;
            }
            if (k >= nums.length - 1) return true;
            k = Math.max(k, i + nums[i]);
        }

        return true;
    }
}