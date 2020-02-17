/**
 *
 * 三数之和
 * 核心思想 排序 + 双指针 或者 使用哈希表
 * 排序 + 双指针 中 1. 排序是前提(特别注意排序问题) 2. 双指针向内收敛
 * 难以想到的地方:
 * sum = 0的时候去完重复 i和j都需要变化 i++ j--
 * 
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //结果保存在list集合中
         List<List<Integer>> result = new  ArrayList<>();
        //排序
        Arrays.sort(nums);
        //遍历集合
        //定义2个指针 i、j
        int i;
        int j;
        for (int k = 0; k < nums.length; k++) {
            // 因为已经排好序nums[k],nums[i],nums[j]中nums[k]最小,如果nums[k]大于0那么三数只和就不可能等于0,直接返回
            if (nums[k] > 0) break;
            //k对应元素去重
            if (k > 0 && nums[k] == nums[k-1])  continue;
            i = k + 1; //i从k的下一个元素开始
            j = nums.length - 1;//j从最后一个元素开始
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if ( sum == 0) {
                    result.add(Arrays.asList(nums[k],nums[i],nums[j]));
                    //i、j元素去重
                    while (i < j && nums[i] == nums[i+1]) { i++; }
                    while (i < j && nums[j] == nums[j-1]) { j--; }
                    i++;
                    j--;
                }
                else if (sum < 0) i ++;
                else   j --; 
            }
        }
        return result;
    }
}