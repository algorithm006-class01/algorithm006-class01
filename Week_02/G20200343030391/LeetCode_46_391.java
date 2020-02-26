package G20200343030391;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_46_391 {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        List<List<Integer>> permute = new LeetCode_46_391().permute(nums);
        System.out.println(permute);

    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), used);
        return res;

    }

    /**
     * 回溯
     *  @param res
     * @param nums
     * @param tmp
     * @param used
     */
    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, boolean[] used) {
        //递归跳出条件，拿满一组返回结果
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 当前元素在这一组已经使用过
            if (used[i]) {
                continue;
            }

            //递归逻辑 元素标记为已经使用过，加入本组
            used[i] = true;
            tmp.add(nums[i]);
            System.out.println(nums[i]);

            //递归
            backtrack(res, nums, tmp, used);
            //回溯，撤销选择重置当前元素为未使用
            used[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }

}
