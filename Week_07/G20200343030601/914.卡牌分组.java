/*
 * @lc app=leetcode.cn id=914 lang=java
 *
 * [914] 卡牌分组
 *
 * https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/description/
 *
 * algorithms
 * Easy (32.91%)
 * Likes:    137
 * Dislikes: 0
 * Total Accepted:    30.3K
 * Total Submissions: 78.9K
 * Testcase Example:  '[1,2,3,4,4,3,2,1]'
 *
 * 给定一副牌，每张牌上都写着一个整数。
 * 
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * 
 * 
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 
 * 
 * 仅当你可选的 X >= 2 时返回 true。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 
 * 
 * 示例 2：
 * 
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 
 * 
 * 示例 3：
 * 
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 
 * 
 * 示例 4：
 * 
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * 
 * 
 * 示例 5：
 * 
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] < 10000
 * 
 * 
 * 
 * 
 */

// @lc code=start
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
class Solution {
    // 思路：暴力，先统计不同数字的各自数量，依次判断是否存在能被整除的数g
    // 时间复杂度：O(N^2)  N为数字个数
    // 空间复杂度：O(N) 
    public boolean hasGroupsSizeX1(int[] deck) {
        int[] counts = new int[10000];
        for (int c : deck) {
            counts[c]++;
        }

        for (int X = 2; X <= deck.length; X++) {
            if (deck.length % X != 0) continue;

            boolean flag = true;
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > 0 && counts[i] % X != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) return true;
        }

        return false;
    }

    // 思路：暴力，先统计不同数字的各自数量，依次判断是否存在能被整除的数g
    //      尝试continue [flag], break [flag] 用法
    // 时间复杂度：O(N^2)  N为数字个数
    // 空间复杂度：O(N) 
    public boolean hasGroupsSizeX2(int[] deck) {
        int[] counts = new int[10000];
        for (int c : deck) counts[c]++;

        List<Integer> values = new ArrayList();
        for(int c : counts)
            if (c > 0)
                values.add(c);
        
        search : for (int X = 2; X <= deck.length; X++)
            if (deck.length % X == 0) {
                for (int v : values)
                    if (v % X != 0)
                        continue search;
                return true;
            }

        return false;
    }

    // 思路：暴力，先统计不同数字的各自数量，依次判断是否存在能被整除的数g
    //      尝试continue [flag], break [flag] 用法
    // 时间复杂度：O(N^2)  N为数字个数
    // 空间复杂度：O(N) 
    public boolean hasGroupsSizeX3(int[] deck) {
        int[] counts = new int[10000];
        for (int c : deck) counts[c]++;

        int X = -1;
        for (int c : counts)
            if (c > 0) X = (-1 == X) ? c : greatCommonDivisor(X, c); 
        
        return X >= 2;
    }

    // 求最大公约数
    private int greatCommonDivisor(int x, int y) {
        return  y % x == 0 ? x : greatCommonDivisor(y % x, x);
        // return x == 0 ? y : greatCommonDivisor(y % x, x);
    }

    // 国际站参考简洁写法
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int i : deck) count.put(i, count.getOrDefault(i, 0) + 1);
        for (int i : count.values()) res = gcd(i, res);
        return res > 1;
    }

    public int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}
// @lc code=end

