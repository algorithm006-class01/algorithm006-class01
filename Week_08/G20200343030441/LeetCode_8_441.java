/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        if (str.length() == 0) return 0;
        // 去除空格
        while (str.charAt(index) == ' '){
            index++;
            if (index == str.length()) return 0;
        }

        // 判断符号
        if (str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '-' ? -1 : 1;
            index++;
        }

        // 处理数字或字母
        while (index < str.length()){
            int currentNum = str.charAt(index) - '0';
            if (currentNum > 9 || currentNum < 0) break;
            else {
                // 处理溢出
                if (total > Integer.MAX_VALUE/10 || 
                    Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < currentNum){
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                else {
                    total = 10 * total + currentNum;
                }
            }
            index++;
        }

        return total*sign;
    }
}
// @lc code=end

