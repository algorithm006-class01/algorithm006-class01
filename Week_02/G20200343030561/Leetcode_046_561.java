import java.util.*;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int l;
    public List<List<Integer>> permute(int[] nums) {
        l = nums.length;
        backtrace(0, new ArrayList<Integer>() {{ for (int i : nums) add(i); }});
        return res;
    }

    private void backtrace(int i, ArrayList<Integer> nums) {
        if (i == l) {
            res.add(new ArrayList<Integer>(nums));
        }
        for (int j = i; j < l; j ++) {
            backtrace(i+1, swap(nums, i, j));
        }
    }

    public ArrayList<Integer> swap (ArrayList<Integer> arr, int i, int j) {
        ArrayList<Integer> newArr = new ArrayList<Integer>(arr);
        int tmp = newArr.get(i);
        newArr.set(i, newArr.get(j));
        newArr.set(j, tmp);
        return newArr;
    }
}
// @lc code=end

