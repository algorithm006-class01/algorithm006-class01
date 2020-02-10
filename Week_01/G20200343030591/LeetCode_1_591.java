
class Solution {


    /**
     * 题目名称：两数之和
     * 思路解析：
     *
     * 易错点，老是想让i从1开始，他俩从同一个位置开始走
     * @param nums
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int result = target - nums[i];
            if (cache.get(result)!=null) {
                return new int[]{i, cache.get(result)};
            }
            cache.put(nums[i], i);
        }

        return new int[]{};
    }



