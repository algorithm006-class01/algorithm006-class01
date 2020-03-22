class LeetCode_1_029 {
	/**
	 * 题目描述：
	 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
	 *
	 * 说明：每次只能向下或者向右移动一步。
	 *
	 * 示例:
	 *
	 * 输入:
	 * [
	 *   [1,3,1],
	 *   [1,5,1],
	 *   [4,2,1]
	 * ]
	 * 输出: 7
	 * 解释: 因为路径 1→3→1→1→1 的总和最小。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int minPathSum(int[][] grid) {
		for(int i = grid.length - 1; i >= 0; i--) {
			for(int j = grid[0].length -1; j >= 0; j--) {
				if(i == grid.length - 1 && j != grid[0].length - 1) {
					// 最底下一行处理
					grid[i][j] = grid[i][j] + grid[i][j + 1];
				}else if(j == grid[0].length - 1 && i != grid.length -1) {
					// 最右一行的处理
					grid[i][j] = grid[i][j] + grid[i + 1][j];
				}else if(j != grid[0].length -1 && i != grid.length - 1) {
					// 中间节点处理
					grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j+ 1]);
				}
			}
		}
		return grid[0][0];
	}

	public static void main(String args[]) {
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(minPathSum(grid));
	}
}