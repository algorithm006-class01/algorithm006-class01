<?php

class SolutionPlusOne
{
    /**
     * 加一
     * @param integer[] $digits
     * @return integer[]
     */
    public function plusOne($digits)
    {
        $scale10 = 10; // 十进制

        $length = count($digits);
        $maxDigit = $length * ($scale10 - 1); // 指定长度的最大值

        // 最大值情况
        if (array_sum($digits) == $maxDigit) {
            $digits = array_fill(0, $length+1, 0);
            $digits[0] = 1;
            return $digits;
        }

        for ($i = $length - 1; $i >= 0; $i--) {
            // +1为10则进一位，否则末位+1
            if (($digits[$i] + 1) >= $scale10) {
                $digits[$i] = 0;
            } else {
                $digits[$i]++;
                break;
            }
        }

        return $digits;
    }
}