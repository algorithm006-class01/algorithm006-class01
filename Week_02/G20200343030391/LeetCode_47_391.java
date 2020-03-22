package G20200343030391;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_47_391 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = new LeetCode_47_391().permuteUnique(nums);
        System.out.println(lists);

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        // 修改 1：排序（这里用升序），为了剪枝方便
        Arrays.sort(nums);
        backtrack(result, nums, used, new ArrayList<>());
        return result;
    }

    /**
     * 回溯
     *
     * @param result
     * @param used
     * @param group
     */
    private void backtrack(List<List<Integer>> result, int[] nums, boolean[] used, ArrayList<Integer> group) {
        //递归终止条件
        if (group.size() == used.length) {
            result.add(new ArrayList<>(group));
        }
        for (int i = 0; i < nums.length; i++) {
            //执行逻辑 跳过已经使用过的
            if (used[i]) {
                continue;
            }
            //跳过上一个已经用过，而且更当前元素相同
            if (i > 0 && used[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }
            used[i] = true;
            group.add(nums[i]);
            backtrack(result, nums, used, group);
            //回溯，撤销决策
            used[i] = false;
            group.remove(group.size() - 1);
        }
    }

}
