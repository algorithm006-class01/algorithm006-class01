package main

/*
 * @lc app=leetcode.cn id=773 lang=golang
 *
 * [773] 滑动谜题
 *
 * https://leetcode-cn.com/problems/sliding-puzzle/description/
 *
 * algorithms
 * Hard (57.66%)
 * Likes:    45
 * Dislikes: 0
 * Total Accepted:    2K
 * Total Submissions: 3.4K
 * Testcase Example:  '[[1,2,3],[4,0,5]]'
 *
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 *
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 *
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 *
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 *
 * 示例：
 *
 *
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 *
 *
 *
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 *
 *
 *
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 *
 *
 *
 * 输入：board = [[3,2,4],[1,5,0]]
 * 输出：14
 *
 *
 * 提示：
 *
 *
 * board 是一个如上所述的 2 x 3 的数组.
 * board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
 *
 *
 */

// @lc code=start
func slidingPuzzle(board [][]int) int {
	move := [][]int{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}}
	startSlice := append(board[0], board[1]...)
	var start [6]int
	sliceToArr(startSlice, &start)
	end := [...]int{1, 2, 3, 4, 5, 0}
	queue := [][6]int{start}
	visited := make(map[[6]int]bool, 0)
	visited[start] = true
	cnt := 0

	for len(queue) > 0 {
		len := len(queue)
		for i := 0; i < len; i++ {
			curState := queue[0]
			queue = queue[1:]
			if curState == end {
				return cnt
			}

			zeroIdx := getZeroIndex(&curState)
			for _, v := range move[zeroIdx] {
				tmp := curState
				tmp[zeroIdx], tmp[v] = tmp[v], tmp[zeroIdx]
				if visited[tmp] {
					continue
				}
				visited[tmp] = true
				queue = append(queue, tmp)
			}
		}
		cnt++
	}
	return -1
}

func sliceToArr(slice []int, arr *[6]int) {
	for i, v := range slice {
		arr[i] = v
	}
	return
}

func getZeroIndex(a *[6]int) int {
	for i, v := range *a {
		if v == 0 {
			return i
		}
	}
	return -1
}

/* func main() {
	input := [][]int{
		{4, 1, 2}, {5, 0, 3}}
	res := slidingPuzzle(input)
	fmt.Println(res)
	return
} */

// @lc code=end
