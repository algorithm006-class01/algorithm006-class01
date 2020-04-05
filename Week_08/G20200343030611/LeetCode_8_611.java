package datast.string;

public class LeetCode_8_611 {

    class Solution {
        public int myAtoi(String str) {
            char[] charArray = str.toCharArray();
            int index = 0;
            while (index < charArray.length && charArray[index] == ' ') {
                index++;
            }
            if (index == charArray.length) return 0;
            // 是否为负数
            boolean flag = false;
            if (charArray[index] == '-') {
                flag = true;
                index++;
            } else if (charArray[index] == '+') {
                index++;
            } else if (!Character.isDigit(charArray[index])) {
                return 0;
            }
            int ans = 0;
            while (index < charArray.length) {
                if (Character.isDigit(charArray[index])) {
                    int digit = charArray[index] - '0';
                    if (ans > (Integer.MAX_VALUE - digit) / 10) {
                        return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    }
                    ans = ans * 10 + digit;
                    index++;
                } else {
                    return flag ? - ans : ans;
                }
            }
            return flag ? - ans : ans;
        }
    }
}
