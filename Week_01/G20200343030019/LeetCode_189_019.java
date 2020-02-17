class Solution {
    public void rotate(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length <= 1) {
            return;
        }
        int startIndex = 0;
        int index = 0;
        int tmp = nums[0];
        int tmp2 = 0;
        int nextIndex = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i > 0 && startIndex == index) {
                index ++;
                startIndex ++;
                tmp = nums[index];
            }
            nextIndex = (index + k) % nums.length;
            tmp2 = nums[nextIndex];
            nums[nextIndex] = tmp;
            index = nextIndex;
            tmp = tmp2;
        }
    }
}