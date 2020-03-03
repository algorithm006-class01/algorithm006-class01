import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null) {return result;}
        _dfs(result, nums, new ArrayList<Integer>(), 0);

        return result;
    }

    private void _dfs(List<List<Integer>> result, int[] nums, List<Integer> list, int index){

        if (index == nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }

        _dfs(result, nums, list, index+1);

        list.add(nums[index]);

        _dfs(result, nums, list, index+1);

        list.remove(list.size() - 1);
    }
}
// @lc code=end

