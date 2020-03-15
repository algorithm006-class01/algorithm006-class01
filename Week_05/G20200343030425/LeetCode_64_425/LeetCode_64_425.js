/*
* address: https://leetcode-cn.com/problems/minimum-path-sum/
* 输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
* */
const minPathSum = function(grid) {
    if (!grid.length || !grid[0].length) {
        return 0;
    }

    const arr = Array(grid[0].length).fill(Number.MAX_SAFE_INTEGER);
    arr[0] = 0;

    for (let i = 0; i < grid.length; i++) {
        arr[0] += grid[i][0];

        for (let j = 1; j < grid[i].length; j++) {
            arr[j] = Math.min(grid[i][j] + arr[j], grid[i][j] + arr[j - 1]);
        }
    }

    return arr[arr.length - 1];
};
