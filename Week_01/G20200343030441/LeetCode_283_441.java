/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // 方案一
        // int len_nums = nums.length;

        // for (int i = 0; i < len_nums; i++){
        //     if (nums[i] == 0){
        //         for (int j = i; j < len_nums; j++){
        //             if (j == len_nums-1){
        //                 break;
        //             }
        //             if(nums[j+1] != 0){
        //                 nums[i] = nums[j+1];
        //                 nums[j+1] = 0;
        //                 break;
        //             }
        //         }
        //     }
        // }
        //=============================================

        // 方案二 28%
        // int len_nums = nums.length;
        // int count_zeros = 0;
        // for (int i = 0; i < len_nums; i++){
        //     if (nums[i] == 0){
        //         count_zeros++;
        //     }
        // }

        // int count_nums = 0;
        // for (int j = 0; j < len_nums; j++){
        //     if (nums[j] != 0){
        //         nums[count_nums] = nums[j];
        //         count_nums++;
        //     }
        // }

        // for (int q = len_nums-count_zeros; q < len_nums; q++){
        //     nums[q] = 0;
        // }
        //===============================================

        // 方案三，双指针，和方案二其实差不多
        if(nums==null) {
			return;
		}
		//第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
		int j = 0;
		for(int i=0;i<nums.length;++i) {
			if(nums[i]!=0) {
				nums[j++] = nums[i];
			}
		}
		//非0元素统计完了，剩下的都是0了
		//所以第二次遍历把末尾的元素都赋为0即可
		for(int i=j;i<nums.length;++i) {
			nums[i] = 0;
		}
    }
}
// @lc code=end

