/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 *
 * https://leetcode-cn.com/problems/counting-bits/description/
 *
 * algorithms
 * Medium (74.77%)
 * Likes:    259
 * Dislikes: 0
 * Total Accepted:    31.6K
 * Total Submissions: 42.3K
 * Testcase Example:  '2'
 *
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 
 * 示例 1:
 * 
 * 输入: 2
 * 输出: [0,1,1]
 * 
 * 示例 2:
 * 
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 
 * 进阶:
 * 
 * 
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * 
 * 
 */

// @lc code=start
class Solution {
    // 思路：对num内的每一个数，分别计算位为1的数目；
    //      官方称此解法为Pop count
    //      x & (x -1) : 清零最后一位1（不一定是x二进制形式的最后一位数）
    // 时间复杂度: O(num)  ”计算每个数的位为1的数目“的时间复杂度为O(1)
    // 空间复杂度: O(1) 返回值空间不记在内
    public int[] countBits1(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            int temp = i;
            while (temp != 0) {
                result[i]++;
                temp &= (temp - 1);
            }
        }

        return result;
    }

    // 思路：动态规划+最高有效位
    //      两个数字的最高有效位不同，其余各位均相同
    // 状态转移函数：P(x + b) = 1 + P(x), 其中b = 2^m > x
    // 时间复杂度：O(n)
    // 空间复杂度：O(1) 返回值空间不记在内
    public int[] countBits2(int num) {
        int[] result = new int[num + 1];
        for (int b = 1, i = 0; b <=num; b <<= 1, i = 0) {
            // 通过result[0:b) 计算result[b,2b)或result[b,num]
            while(i < b && i + b <= num) {
                result[i + b] = result[i] + 1;
                i++;
            }
        }
        return result;
    }

    // 思路：动态规划+最低有效位
    //     （直觉）只要x'小于x，且它们的pop count之间存在函数关系，就可以写出其他的状态转移函数。
    // 状态转移函数：P(x) = P(x/2) + (x%2)
    // 时间复杂度：O(n)
    // 空间复杂度：O(1) 返回值空间不记在内
    public int[] countBits3(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }

    // 思路：动态规划+最后设置位
    //     最后设置位是从右到左第一个为1的位。使用 x &= x - 1 将该位设置为0。
    //     ***动态规划的状态转移函数 不一定 是在相邻两个x之间的关系，有可能跳跃一些***
    // 状态转移函数：P(x) = P(x & (x - 1)) + 1
    // 时间复杂度：O(n)
    // 空间复杂度：O(1) 返回值空间不记在内
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }

        return result;
    }
}
// @lc code=end

