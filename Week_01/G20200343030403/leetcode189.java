class Solution {

    // 环状替换法
    public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0 || k == nums.length) return;
        int count = 0;

        for (int st = 0;count < nums.length; st ++){
            int current = st;
            int prev = nums[st];
            do {
                int next = (current + k) % nums.length;
                int tmp = nums[next];
                nums[next] = prev;
                prev = tmp;
                current = next;
                count++;
            } while (current != st);
        }
    }

    // 反转
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int st, int ed) {
        int tmp;
        while (st < ed) {
            tmp = nums[st];
            nums[st++] = nums[ed];
            nums[ed--] = tmp;
        }
    }
}