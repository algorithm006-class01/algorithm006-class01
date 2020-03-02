package datast.divide_backtrack;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_78_611 {

    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        pick(0, nums, res, new ArrayList());
        return res;
    }

    public void pick(int index, int[] nums, List res, List list) {
        if (index == nums.length) {
            res.add(new ArrayList(list));
            return;
        }
        pick(index + 1, nums, res, list);
        list.add(nums[index]);
        pick(index + 1, nums, res, list);
        list.remove(list.size() - 1);
    }
}
