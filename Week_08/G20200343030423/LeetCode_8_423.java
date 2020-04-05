public class LeetCode_8_423 {
}

class Solution8 {
    public int myAtoi(String str) {
        int len = str.length();
        char[] charArray = str.toCharArray();
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }
        if (index == len) {
            return 0;
        }
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }
}