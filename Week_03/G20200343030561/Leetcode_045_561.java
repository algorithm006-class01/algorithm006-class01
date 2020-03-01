/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
/*
class Solution {
    public int jump(int[] nums) {
        int pos = nums.length - 1;
        int steps = 0;
        while (pos != 0) {
            for(int i = 0; i < pos; i ++) {
                if(nums[i] + i >= pos) {
                    pos = i;
                    steps ++;
                    break;
                }
            }
        }
        return steps;
    }
}
*/
// bfs liked greedy
class Solution {
    public int jump(int[] nums) {
        int steps = 0, pos = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) { // 不需要i走到最后一个元素
            farthest = Math.max(farthest, i + nums[i]); // current level max size
            if (i == pos) { // already visited all element in current level
                steps++; // level ++;
                pos = farthest; // queue.size();
            }
        }
        return steps;
    }
}
// @lc code=end

