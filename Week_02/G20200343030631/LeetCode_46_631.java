
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(permute(nums));
    }

    /**
     * 解题思路: 递归方式，从两个数的全排列开始
     * 时间复杂度: O(n！)
     * 空间复杂度: 开辟了n的从2~n个全排列之和的空间
     * 执行用时: 76 ms, 在所有 Java 提交中击败了5.76%的用户
     * 内存消耗: 41.4 MB, 在所有 Java 提交中击败了5.04%的用户
     * @Author: loe881@163.com
     * @Date: 2020/3/3
     */
    public static List<List<Integer>> permuteV1(int[] nums) {
        // 存放结果集
        List<List<Integer>> result = new LinkedList();
        // 边界条件
        if (null == nums || nums.length == 0) {
            return result;
        }
        // 只有一个元素的数组，无需排列，直接返回结果
        if (nums.length == 1){
            result.add(new ArrayList<>(Arrays.asList(nums[0])));
            return result;
        }
        permuteV1Internal(nums, result);
        return result;
    }

    /**
     * @param nums 需要全排列的数组
     * @param result 当前数据全排列结果
     */
    private static void permuteV1Internal(int[] nums, List<List<Integer>> result) {
        // 递归终止条件
        if (nums.length == 2){
            result.add(new ArrayList<>(Arrays.asList(nums[0], nums[1])));
            result.add(new ArrayList<>(Arrays.asList(nums[1], nums[0])));
            return;
        }

        // 对数组所有数据逐个处理
        for (int i = 0; i < nums.length; i++) {
            int tmpNum = nums[i];
            // 开辟一个新数组，存储不包含当前值的其他数据
            int[] tmpNums = new int[nums.length - 1];
            int k = 0;
            for (int j = 0; j < nums.length; j++) {
                if (tmpNum != nums[j]){
                    tmpNums[k++] = nums[j];
                }
            }
            // 递归下层
            permuteInternal(tmpNums, result);
            // 本层处理，对下层递归结果逐个处理，加入本层数据
            for (int j = 0; j < result.size(); j++) {
                List<Integer> tmpResult = result.get(j);
                if (tmpResult.size() < nums.length){
                    tmpResult.add(0, tmpNum);
                }
            }
        }
    }

    /**
     * 解题思路: 回溯方式
     * 时间复杂度:
     * 空间复杂度:
     * 执行用时: 3 ms, 在所有 Java 提交中击败了30.68%的用户
     * 内存消耗: 41.6 MB, 在所有 Java 提交中击败了5.04%的用户
     *
     * @Author: loe881@163.com
     * @Date: 2020/3/3
     */
    public static List<List<Integer>> permuteV2(int[] nums) {
        // 存放结果集
        List<List<Integer>> result = new LinkedList();
        // 边界条件
        if (null == nums || nums.length == 0) {
            return result;
        }
        // 只有一个元素的数组，无需排列，直接返回结果
        if (nums.length == 1) {
            result.add(new ArrayList<>(Arrays.asList(nums[0])));
            return result;
        }
        permuteV2Internal(nums, new LinkedList<Integer>(), result);
        return result;
    }

    private static void permuteV2Internal(int[] nums, LinkedList<Integer> currentResult, List<List<Integer>> result) {
        // 终止条件，排列结果集合大小与数据大小一致
        if (currentResult.size() == nums.length) {
            result.add(new LinkedList<Integer>(currentResult));
            return;
        }

        // 编列数组每个元素
        for (int i = 0; i < nums.length; i++) {
            // 如果当前结果已包含该元素，跳过
            if (currentResult.contains(nums[i])) {
                continue;
            }
            // 将数组元素加入当前结果中
            currentResult.add(nums[i]);
            // 回溯下一层
            permuteInternal(nums, currentResult, result);
            // 删去最后添加的元素，继续回溯
            currentResult.removeLast();
        }
    }
}