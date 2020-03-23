/*
 * @lc app=leetcode.cn id=945 lang=java
 *
 * [945] 使数组唯一的最小增量
 *
 * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/description/
 *
 * algorithms
 * Medium (42.59%)
 * Likes:    37
 * Dislikes: 0
 * Total Accepted:    5.6K
 * Total Submissions: 12.7K
 * Testcase Example:  '[1,2,2]'
 *
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 * 
 * 示例 1:
 * 
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * 
 * 示例 2:
 * 
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 * 
 * 
 */

// @lc code=start
import java.util.HashSet;
import java.util.Arrays;
class Solution {
    // 暴力法（超时）
    // 时间复杂度：O(N*N) 最差情况是所有值都相等
    // 空间复杂度：O(N)
    public int minIncrementForUnique1(int[] A) {
        HashSet<Integer> unique = new HashSet<Integer>();
        int moveCount = 0;
        for (int a : A) {
            while(unique.contains(a)) {
                a++;
                moveCount++;
            }
            unique.add(a);
        }
        return moveCount;
    }

    // 计数法
    // 未出现的数字和 - 重复的数字和 = move的步数
    // 未出现的数字个数 == 重复的数字个数，而且要先有重复数字，才能用未出现的数字抵消（因为数字只能增）
    // 空间复杂度：O(L),L的数量级为数组A的长度加上其数据范围内的最大值
    // 空间复杂度：O(L)
    public int minIncrementForUnique2(int[] A) {
        int[] count = new int[80000];
        for (int a : A) count[a]++;

        int ans = 0, token = 0;  // ans: move的步数   token: 重复的数字个数
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= 2) {
                token += count[i] - 1;
                ans -= i * (count[i] - 1);
            } else if (token > 0 && count[i] == 0) {
                ans += i;
                token--;
            }
        }

        return ans;
    }

    // 计数法（早停）
    // 关键点：在已处理完A中最大值之后，且重复值也都处理完之后，就可以及时停止
    // 时间复杂度和空间复杂度同上
    public int minIncrementForUnique3(int[] A) {
        int[] count = new int[80000];
        int maxA = 0;
        for (int a : A) {
            count[a]++;
            if (a > maxA) maxA = a;
        }

        int ans = 0, taken = 0;  // ans: move的步数   token: (未处理的)重复的数字个数
        for (int i = 0; i < count.length && (i <= maxA || taken > 0); i++) {
            if (count[i] >= 2) {
                taken += count[i] - 1;
                ans -= i * (count[i] - 1);
            } else if (taken > 0 && count[i] == 0) {
                ans += i;
                taken--;
            }
        }

        return ans;
    }

    // 排序法
    // 时间复杂度O(NlogN),N是数组长度
    // 空间复杂度O(logN),排序需要额外的栈空间
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int ans = 0, taken = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] == A[i]) { // 针对重复值进行计数
                taken++;
                ans-= A[i];
            }
            else if (A[i] - A[i - 1] > 1){ // 在排序数组间出现空档时，计算填充需要的步数
                int give = Math.min(taken, A[i] - A[i - 1] - 1);  // 可插入数值的总个数
                ans += give * (give + 1) /2 + give * A[i - 1];    // 可插入数值的和
                taken -= give;
            }
        }

        if (taken > 0) // 还有为抵消的重复值
            ans += taken * (taken + 1) / 2 + taken * A[A.length - 1];
        
        return ans;
    }
}
// @lc code=end

