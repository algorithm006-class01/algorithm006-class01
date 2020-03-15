<?php
class Solution {
    /**
     * @param String $s
     * @return Integer
     */
    function numDecodings($s) {
        $dp = [];
        $len = strlen($s);          
        if($len == 0) return 0;     
        $dp[0] = $s[0] == '0' ? 0:1;
        if($len == 1) return $dp[0];
        $flag = ($s[0] > 0 && $s[1] > 0) ? 1:0; 
        $dp[1] = $flag + (($s[0] == 1 || ($s[0] == 2 && $s[1] <= 6)) ? 1:0);
        for($i = 2;$i<$len;++$i){
            $dp[$i] = $s[$i] == 0 ? 0:$dp[$i-1];    
            $dp[$i] += ($s[$i-1] == 1 || ($s[$i-1] == 2 && $s[$i] <= 6)) ? $dp[$i-2] : 0;
        }
        return $dp[$len-1];
    }
}
