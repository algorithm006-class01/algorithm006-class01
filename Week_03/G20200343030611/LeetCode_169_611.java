package datast.divide_backtrack;

public class LeetCode_169_611 {

    /**
     * \
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        return searchMajor(nums, 0, nums.length - 1);
    }

    private int searchMajor(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = (right - left) / 2 + left;
        int leftValue = searchMajor(nums, left, mid);
        int rightValue = searchMajor(nums, mid + 1, right);
        if (leftValue == rightValue) return leftValue;
        int leftCount = count(nums, leftValue, left, right);
        int rightCount = count(nums, rightValue, left, right);
        return leftCount > rightCount ? leftValue : rightValue;
    }

    private int count(int[] nums, int num, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (num == nums[i]) count++;
        }
        return count;
    }
}
