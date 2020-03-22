package G20200343030379;

/**
 *  45. 跳跃游戏 II
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * ?    从下标为 0 跳到下标为 1 的位置，跳?1?步，然后跳?3?步到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  优秀题解：(具体先看思路)
 *  https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
 *
 *
 */



public class LeetCode_45_379 {
    public static void main(String[] args) {
        new LeetCode_45_379().jump(new int[]{2,3,1,1,4,1});
    }

    /**
     * 贪心算法
     *
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 95.03% 的用户
     * 内存消耗 : 41 MB , 在所有 Java 提交中击败了 5.04% 的用户
     * @return
     */
    public int jump(int[] nums) {
        //前一个结点最远能到达的位置
        int end=0;
        //当前结点最远能到达的位置
        int maxPosition=0;
        //跳跃次数
        int setp=0;

        //nums.length-1 由于可能最后一个是最大的，所以最后一个不需要判断，否则出现多一个步骤的情况
        for (int i = 0; i < nums.length-1; i++) {
            maxPosition=Math.max(maxPosition,nums[i]+i);
            //更新边界值
            if(end==i){
                end=maxPosition;
                setp++;
            }
        }
        return setp;
    }

}
