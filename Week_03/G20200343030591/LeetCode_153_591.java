class Solution {
    /**
     * 情况1：
     * 如果中间数比右界大，说明 得在 [mid+1,right]这个区间找 eg:[3,4,5,6,1] 不包含mid
     * 一直在右半边找，直到 left == right后就会 停止运行，此时left就是最小值，如果要是要断开的地方则 返回right就好了
     *
     *  如果中间数比右界小，说明 得在 [left,mid]这个区间找 eg:[7,8,1,2,3] 包含mid
     *  先在左半边找，再在右边界找，直到 left == right 返回最左边的值即可
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0 || nums == null) {
            throw new IllegalArgumentException("数组为空");
        }

        int left = 0;
        int right = len - 1;

        while (left < right) {
            // 发现 可以这么写 等价于 left + (right - left) / 2
            int mid = (right + left) >>> 1;

            // 如果中间数 比 数组 右界大 说明 [mid, right] 这个区间是 递减的 被旋转过
            // 继续向 前找 看看下一个值是否满足 中间数比 右界大
            // eg [3,4,5,6,1] 第一次 中位数 为的下标位2 值为5 大于 右界的值 1 那么继续向前找 即 继续在 [mid+1, right]这个区间找
            // 第二次 mid=3 值为6
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // 如果中间数 比 数组 右界小 说明没被旋转过 也就是 [mid,right]这一段 没被旋转过
                right = mid;
            }
        }
        return nums[left];
    }
}