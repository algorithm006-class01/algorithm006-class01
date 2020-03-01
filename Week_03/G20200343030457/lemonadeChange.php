<?php

class Solution {

    /**
     * @param Integer[] $bills
     * @return Boolean
     */
    function lemonadeChange($bills)
    {    
        $profit = 0;
        for($i = 0;$i < count($bills)-1;$i++){
            $pro = $bills[$i+1] - $bills[$i];
            if ($pro > 0) {
                $profit += $pro;
            }  
        }
        return $profit;
    }
}
