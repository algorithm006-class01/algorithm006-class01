<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $k
     * @return NULL
     */
    function rotate(&$nums, $k) {
        $len = count($nums);
        if ($k > $len) {
            $k = $k % $len;
        }
        $nums = $this->reverse($nums, 0, $len - 1);
        $nums = $this->reverse($nums, 0, $k - 1);
        $nums = $this->reverse($nums, $k, $len - 1);
        return $nums;
    }

    private function reverse($nums, $left, $right)
    {
        while ($left <= $right) {
            $temp = $nums[$left];
            $nums[$left] = $nums[$right];
            $nums[$right] = $temp;
            $left++;
            $right--;
        }

        return $nums;
    }
}
