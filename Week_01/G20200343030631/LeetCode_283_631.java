public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 解题思路: 不考虑限定条件，复制一个数组作为结果数组
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * 执行用时: 0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗: 41.9 MB, 在所有 Java 提交中击败了5.01%的用户
     * @Author: loe881@163.com
     * @Date: 2020/2/25
     */
    public static void moveZeroesV1(int[] nums) {
        // 边界条件
        if (null == nums || nums.length == 0){
            return;
        }
        // 新建一个数组存放结果
        int[] result = new int[nums.length];
        // 默认全部填充为0
        Arrays.fill(result, 0);
        for (int i = 0, j = 0; i < nums.length; i++) {
            // 碰到非0元素，放在新数组中
            if (nums[i] != 0){
                result[j++] = nums[i];
            }
        }
        // 将新数组每个元素值复制给nums
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    /**
     * 解题思路: 优化复制方式，不复制，改为用一个标记位记录指向非0元素最后的位置，
     * 碰到0不动，碰到非零则复制到最后一个非零位置之后，最后形成非零数组，再从数组末尾开始赋值为记录个数个0
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * 执行用时: 0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗: 41.9 MB, 在所有 Java 提交中击败了5.01%的用户
     * @Author: loe881@163.com
     * @Date: 2020/2/25
     */
    public static void moveZeroesV2(int[] nums) {
        // 边界条件
        if (null == nums || nums.length == 0){
            return;
        }
        int lastNoneZero = 0;
        int length = nums.length;
        // 满足需求1，数组非零元素有序
        for (int i = 0; i < length; i++) {
            // 非0，则同步移动，遇到0则lastNoneZero不更新，lastNoneZero指向最新一个0元素位置
            if (nums[i] != 0){
                nums[lastNoneZero++] = nums[i];
            }
        }
        // 满足需求2，0元素均在末尾
        for (int i = lastNoneZero; i < length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 解题思路: 继续优化标记位置算法，标记同时移动0，交换元素，减少后续循环操作
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * 执行用时: 0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗: 41.9 MB, 在所有 Java 提交中击败了5.01%的用户
     * @Author: loe881@163.com
     * @Date: 2020/2/25
     */
    public static void moveZeroesV3(int[] nums) {
        // 边界条件
        if (null == nums || nums.length == 0){
            return;
        }
        int lastZeroPoint = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                int tmp = nums[i];
                nums[i] = nums[lastZeroPoint];
                nums[lastZeroPoint++] = tmp;
            }
        }
    }
}