<?php

class Solution {
    /**
     * @param Integer[][] $grid
     * @return Integer
     */
    function minPathSum($grid) {
        $row = count($grid);
        if($row == 0) return 0;
        $col = count($grid[0]);
        for($i = 0;$i<$row;++$i){
            for($j = 0;$j<$col;++$j){
                if($i == 0){
                    $grid[$i][$j] += empty($grid[$i][$j-1]) ? 0:$grid[$i][$j-1];
                }elseif($j == 0){
                    $grid[$i][$j] += $grid[$i-1][$j];
                }else{
                    $grid[$i][$j] += min($grid[$i-1][$j],$grid[$i][$j-1]);
                }
            }
        }
        return $grid[$row-1][$col-1];
    }
}
