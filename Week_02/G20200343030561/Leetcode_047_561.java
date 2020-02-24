import java.util.*;
/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
// swap backtrace
// 需去重
// @date Feb 21 2020
/* class Solution {
    int l;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        l = nums.length;
        backtrace(new ArrayList<Integer>(){{for(int n:nums) add(n);}}, 0);
        return res;
    }
    private void backtrace(ArrayList<Integer> nums, int i) {
        if (i == l && !used(nums))
            res.add(new ArrayList<Integer>(nums));
            
        for(int j = i; j < l; j ++) 
            backtrace(swap(nums, i, j), i + 1);
    }

    private ArrayList<Integer> swap(ArrayList<Integer> arr, int i, int j) {
        ArrayList<Integer> newArr = new ArrayList<>(arr);
        int temp = arr.get(i);
        newArr.set(i, arr.get(j));
        newArr.set(j, temp);
        return newArr;
    }

    private boolean used(ArrayList<Integer> arr) {
        for(List<Integer> a : res)
            if(a.equals(arr)) return true;
        return false;
    }
} */
// list add backtrace
// 需排序
// @date Feb 22 2020
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int l;
    public List<List<Integer>> permuteUnique(int[] nums) {
        l = nums.length;
        Arrays.sort(nums);
        backtrace(nums, new ArrayList<Integer>(), new boolean[l]);
        return res;
    }
    private void backtrace(int[] nums, ArrayList<Integer> list, boolean[] used){
        if (list.size() == l) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < l; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i -1] && !used[i - 1]) continue;

            used[i] = true;
            list.add(nums[i]);
            backtrace(nums, list, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
// @lc code=end

