/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 *
 * https://leetcode-cn.com/problems/assign-cookies/description/
 *
 * algorithms
 * Easy (52.98%)
 * Likes:    137
 * Dislikes: 0
 * Total Accepted:    26.6K
 * Total Submissions: 50.1K
 * Testcase Example:  '[1,2,3]\n[1,1]'
 *
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi
 * ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i
 * ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 
 * 注意：
 * 
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,2,3], [1,1]
 * 
 * 输出: 1
 * 
 * 解释: 
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1,2], [1,2,3]
 * 
 * 输出: 2
 * 
 * 解释: 
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 * 
 * 
 */

 /*
 * 思路：（贪心）发给孩子i满足他的饼干尺寸gi的最小饼干尺寸sj；
 *       否则，sj可能会满足不了其他胃口更大的孩子，导致少一位孩子被满足。
 *       实现：1.先对孩子胃口、饼干尺寸进行排序；
 *            2.按上述贪心规则进行分配
 *       修正：在代码中设置了count计数，后发现和iChild始终一致，故删除；
 */
// @lc code=start
import java.util.Arrays;
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int iChild = 0, iCookie = 0;
        while(iChild < g.length && iCookie < s.length) {
            if (g[iChild] <= s[iCookie]) {
                iChild++;
            }
            iCookie++;
        }
        
        return iChild;
    }
}
// @lc code=end

