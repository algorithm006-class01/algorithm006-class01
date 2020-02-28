package G20200343030391;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_78_391 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = new LeetCode_78_391().subsetsByLoop(nums);
        System.out.println(subsets);

    }

    /**
     * 1 递归解法，每层分为选和不选两个逻辑分支
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        recursion(result, nums, new ArrayList<>(), 0);
        return result;
    }

    /**
     * 递归
     *
     * @param result
     * @param nums
     * @param list
     * @param index
     */
    private void recursion(List<List<Integer>> result, int[] nums, ArrayList<Integer> list, int index) {
        //terminator
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        //不使用下标index元素
        recursion(result, nums, list, index + 1);
        //使用下标index元素
        list.add(nums[index]);
        recursion(result, nums, list, index + 1);

        //回溯
        list.remove(list.size() - 1);
    }
    /**
     * 2 循环遍历
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsByLoop(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int j = 0; j < nums.length; j++) {
            int n = nums[j];
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<>(res.get(i));
                newSub.add(n);
                res.add(newSub);
            }
        }
        return res;
    }


}
