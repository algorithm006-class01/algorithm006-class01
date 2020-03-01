class LeetCode_45_505 {
    public int jump(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int position = nums.length - 1;
        int steps = 0;
        while (position != 0) {
            for (int i=0;i<position;++i) {
                if (nums[i] + i >= position) {
                    ++steps;
                    position = i;
                    break;
                }
            }
        }
        return steps;
    }
}