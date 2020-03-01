package G20200343030015.week_02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by majiancheng on 2020/2/23.
 */
public class LeetCode_46_015 {

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> arr = new LinkedList<Integer>();
        helper(nums, arr);

        return result;
    }

    public void helper(int[] nums, LinkedList<Integer> arr) {
        if (nums.length == arr.size()) {
            result.add(new ArrayList<>(arr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (arr.contains(nums[i])) {
                continue;
            }

            arr.add(nums[i]);
            helper(nums, arr);
            arr.removeLast();
        }
    }

}
