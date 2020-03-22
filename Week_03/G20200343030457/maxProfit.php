<?php

class Solution {

    /**
     * @param Integer[] $prices
     * @return Integer
     */
    function maxProfit($prices) {

        $profit = 0;
        for($i = 0;$i < count($prices)-1;$i++){
            $pro = $prices[$i+1] - $prices[$i];
            if($pro > 0) $profit += $pro;
        }
        return $profit;
    }
}
