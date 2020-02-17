class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int index = 0; index < nums.length; index ++) {
            if (map.containsKey(target - nums[index])) {
                return new int[]{map.get(target - nums[index]), index};
            }
            map.put(nums[index], index);
        }

        throw new RuntimeException("not have tow num sum to target!");
    }
}