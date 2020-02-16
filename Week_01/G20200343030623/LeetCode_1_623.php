<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {
        $hashArr = array_flip($nums);
        forEach($nums as $i => $num) {
            $difference = $target - $num;
            if(isset($hashArr[$difference]) && $hashArr[$difference]!== $i) {
                return [$i,$hashArr[$difference]];
            }
        }
    }
}
