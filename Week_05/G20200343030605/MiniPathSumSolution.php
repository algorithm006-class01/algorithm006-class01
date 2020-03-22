<?php

class MiniPathSumSolution {

    /**
     * @param array $grid
     * @return int
     */
    function miniPathSum (array $grid) {
        // m*n
        $m = count($grid);
        $n = count($grid[0]);

        // 拷贝$grid用于初始化同样空间的dp数组，以及dp的第一行和第一列
        $dp = $grid;
        for ($i = 1; $i < $m; $i++) {
            $dp[$i][0] += $dp[$i-1][0];
        }
        for ($i=1; $i < $n; $i++) {
            $dp[0][$i] += $dp[0][$i-1];
        }

        // 填满dp矩阵
        for($i=1; $i < $m; $i++){
            for($j=1; $j < $n; $j++){
                $dp[$i][$j] = min($dp[$i-1][$j], $dp[$i][$j-1]) + $grid[$i][$j];
            }
        }

        return $dp[$m-1][$n-1];
    }
}

$solution = new MiniPathSumSolution();
$grid = [
    [1, 2, 3],
    [1, 2, 3],
    [1, 2, 3]
];
echo $solution->miniPathSum($grid);