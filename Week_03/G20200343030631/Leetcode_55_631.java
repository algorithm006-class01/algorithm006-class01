package com.dsx.fifty.five;

/**
 * 解题思路: 贪心算法，从末端开始标记。根据每一个元素走自己的最大步数后，是否能到达上一个可以达到末尾的元素分类元素，
 * 如果能到达第一个元素，说明可以第一个元素可以达到最后位置
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
class Solution {
    public static void main(String[] args) {
        int[] testCase = new int[]{2,3,1,1,4};
        System.out.println(canJump(testCase));
    }

    public static boolean canJump(int[] nums) {
        // 边界条件
        if (null == nums || nums.length == 0){
            return false;
        }
        // 保存最后一个可跳到末尾的元素位置
        int lastCanJumpPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            if (nums[i] + i >= lastCanJumpPos){
                lastCanJumpPos = i;
            }
        }
        return lastCanJumpPos == 0;
    }
}
