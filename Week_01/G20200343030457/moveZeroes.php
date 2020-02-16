<?php

class Solution
{
    /**
     * @param Integer[] $nums
     * @return NULL
     */
    function moveZeroes(&$nums)
    {
        for ($i = 0, $count = count($nums); $i < $count; $i++) {
            if ($nums[$i] == 0) {
                $nums[] = 0;
                unset($nums[$i]);
            }
        }

        return $nums;
    }
}
