<?php

class SolutionRemoveDuplicates
{
    /**
     * 删除排序数组中的重复项
     * @param Integer[] $nums
     * @return Integer
     */
    public function removeDuplicates(&$nums) {
        $length = count($nums);
        if ($length <= 1) {
            return $length;
        }

        // 双指针思路，$i为慢指针，$j在前为快指针
        for ($i = 0, $j = 1; $j < $length; $j ++) {
            //
            if ($nums[$j] != $nums[$i]) {
                // 递增慢指针，并拷贝快指针对应值给慢指针
                $i++;
                $nums[$i] = $nums[$j];
            }
        }

        return $i + 1;

    }
}
