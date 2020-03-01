
class Solution {

    /**
     * 全排列
     * 这道题 感觉自己思考不出来 直接看了答案
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        generatePermute(lists, new ArrayList<>(), nums, 0);
        return lists;
    }

    /**
     *
     * @param permuteLists 存储全排列 即最终的结果
     * @param list 存储其中一个排列 存储本层的排列结果
     * @param nums 给定的序列
     * @param cursorPos 
     */
    private static void generatePermute(
            List<List<Integer>> permuteLists, List<Integer> list, int[] nums, int cursorPos) {
        if (cursorPos == nums.length) {
            // 必须要 new 一个 list 再 add，因为list 是引用传递
            // 在退出递归时 list.remove 会把 list 清空，permuteLists 也会变空
            permuteLists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i <= cursorPos; i++) {
            list.add(i, nums[cursorPos]);
            generatePermute(permuteLists, list, nums, cursorPos + 1);
            list.remove(i);
        }
    }
}