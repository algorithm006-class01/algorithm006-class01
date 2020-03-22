/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 *
 * https://leetcode-cn.com/problems/friend-circles/description/
 *
 * algorithms
 * Medium (53.95%)
 * Likes:    198
 * Dislikes: 0
 * Total Accepted:    29.6K
 * Total Submissions: 53.4K
 * Testcase Example:  '[[1,1,0],[1,1,0],[0,0,1]]'
 *
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是
 * C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * 
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j
 * 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 
 * [[1,1,0],
 * ⁠[1,1,0],
 * ⁠[0,0,1]]
 * 输出: 2 
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: 
 * [[1,1,0],
 * ⁠[1,1,1],
 * ⁠[0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * 
 * 
 * 注意：
 * 
 * 
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 * 
 * 
 */

// @lc code=start
class Solution {
  public static void main(String[] args) {
    int[][] bills = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
    int result = findCircleNum(bills);
    System.out.println(result);
  }

  private static int n;
  private static int m;

  // DFS
  public static int findCircleNum(int[][] M) {
    int count = 0;
    n = M.length;
    if (n == 0) {
      return count;
    }
    m = M[0].length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (M[i][j] == 1) {
          DFSMarking(M, i, j);
          count++;
        }

      }
    }
    return count;
  }

  private static void DFSMarking(int[][] M, int i, int j) {
    if (i < 0 || j < 0 || i >= n || j >= m || M[i][j] != 1) {
      return;
    }
    M[i][j] = 0;
    DFSMarking(M, i + 1, j);
    DFSMarking(M, i - 1, j);
    DFSMarking(M, i, j + 1);
    DFSMarking(M, i, j - 1);
  }
}
// @lc code=end
