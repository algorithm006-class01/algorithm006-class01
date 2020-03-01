package cn.geek.week2;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月23日 07:51:00
 */
public class LeetCode_046_363 {

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> tempLink = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        backtrack(nums, tempLink, res);
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> res) {

        if (nums.length == track.size()) {
            res.add(new LinkedList<>(track));
        }

        for (int i = 0; i < nums.length; i++) {

            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track, res);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        LeetCode_046_363 leetcode = new LeetCode_046_363();
        List<List<Integer>> resList = leetcode.permute(new int[] {1, 2, 3});
        for (List<Integer> list : resList) {
            System.out.println(list);
        }
    }
}
