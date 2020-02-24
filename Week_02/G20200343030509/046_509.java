/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        backtrack(list, new ArrayList<>(), new HashSet<>(), nums);

        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, Set<Integer> tempSet, int[] nums) {
        if(tempSet.size() == nums.length) {
            list.add( new ArrayList<>(tempList));
        }

        for (int i=0; i < nums.length; i++ ) {
            if (tempSet.contains(nums[i])) continue;

            tempList.add(nums[i]);
            tempSet.add(nums[i]);

            backtrack(list, tempList, tempSet, nums);

            tempSet.remove(tempList.get(tempList.size() -1));
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.permute(""));
    }
}