public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(nums, target));
    }

    /**
     * 解题思路: 暴力枚举计算，匹配结果
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     * 执行用时 :50 ms, 在所有 Java 提交中击败了41.96%的用户
     * 内存消耗 :38.9 MB, 在所有 Java 提交中击败了51.69%的用户
     * @Author: loe881@163.com
     * @Date: 2020/2/21
     */
    public static int[] twoSumV1(int[] nums, int target) {
        // 边界条件
        if (null == nums || nums.length == 0){
            throw new UnsupportedOperationException("No Solution");
        }
        int[] results = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int expectNum = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (expectNum == nums[j]) {
                    results[0] = j;
                    results[1] = i;
                }
            }
        }
        return results;
    }

    /**
     * 解题思路: 利用哈希表查找快思想，所有元素放入哈希表，同时为提升效率，将放入元素和查找过程结合，还可以避免一次全部放入，查找时查找到自身的情况
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * 执行用时: 3 ms, 在所有 Java 提交中击败了95.62%的用户
     * 内存消耗: 41.5 MB, 在所有 Java 提交中击败了5.08%的用户
     * @Author: loe881@163.com
     * @Date: 2020/2/21
     */
    public static int[] twoSumV2(int[] nums, int target) {
        // 边界条件
        if (null == nums || nums.length == 0){
            throw new UnsupportedOperationException("No Solution");
        }
        int[] results = new int[2];
        // 将数组元素存放再hashmap内，快速查找
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            // 判断目标值与当前值之差是否在map中，在说明有解
            if (numMap.containsKey(tmp)){
                return new int[]{numMap.get(tmp), i};
            }
            // 不管是否有解，都要把当前值放在map中，用于后续处理
            numMap.put(nums[i], i);
        }
        return results;
    }
}