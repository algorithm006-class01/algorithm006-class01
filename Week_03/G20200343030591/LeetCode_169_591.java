class Solution {

    /**
     *
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * 示例 1:
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     * hash法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int result = 0;
        int len = nums.length;
        int target = len / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i < len; i++) {
            if (map.get(nums[i])!=null) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            Integer value = (Integer) map.get(key);
            if (value > target) {
                result = key;
            }
        }
        return result;
    }
}