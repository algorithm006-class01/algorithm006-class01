package G20200343030015.week_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by majiancheng on 2020/2/23.
 */
public class LeetCode_47_015 {

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], new Stack<Integer>());

        return result;
    }

    /**
     * 套用回溯模板
     * result = []
     * def backtrack(路径, 选择列表):
     * if 满足结束条件:
     * result.add(路径)
     * return
     * <p>
     * for 选择 in 选择列表:
     * 做选择
     * backtrack(路径, 选择列表)
     * 撤销选择
     */
    public void dfs(int[] nums, boolean[] used, Stack<Integer> stack) {
        if (stack.size() == nums.length) {
            this.result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //已使用当前元素需要过滤
            if (used[i] == true) continue;
            //判断是否需要剪枝
            //如果当前元素等于上一个元素 并且还未被使用则剪枝
            //讲解视频
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) continue;
            stack.push(nums[i]);
            used[i] = true;

            dfs(nums, used, stack);

            used[i] = false;
            stack.pop();
        }

    }

}
