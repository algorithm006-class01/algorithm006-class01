//照搬官方的解释，主要是在学习Java的map的使用
class Solution {
    publit[] twoSum(int[] nums, int target) {
        // Map构建方法为Map<键类型, 值类型> 变量名 = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            //查询操作, .containsKey
            if (map.containsKey(complement)) {
                //取值操作.get
                return new int[] { map.get(complement), i };
            }
            //插入操作 .put(key, value)
            map.put(nums[i], i);
        }
        // 丢错报错throw
        throw new IllegalArgumentException("No two sum solution");
    }
}
