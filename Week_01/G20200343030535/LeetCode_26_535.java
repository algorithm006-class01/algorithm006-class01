package leetcode;

public class LeetCode_26_535 {

    /***
     * 题目：
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     */

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0){return 0;}
        int p = 0;  /**p指针用来追踪不同元素的位置*/
        int p1 = 1; /**p1指针用来遍历获取不同的元素的位置*/
        while (p1 < nums.length){
            if (nums[p] != nums[p1]){
                p++;    /**p指针变成了表示要添加元素的位置*/
                nums[p] = nums[p1];
            }
            p1++;
        }
        return p + 1;
    }

    public static void main(String[] args) {

    }

}
