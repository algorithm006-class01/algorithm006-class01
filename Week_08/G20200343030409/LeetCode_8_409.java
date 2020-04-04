/*
    time complexity: O(n), space complexity: O(1)
 */
class Solution {
    private static final int MAX_INTEGER_DIVIDE10 = Integer.MAX_VALUE/10;

    public int myAtoi(String str) {
        int i = 0;
        int n = str.length();
        int sign = 1;
        while(i < n && Character.isWhitespace(str.charAt(i))) i++;

        if(i < n && str.charAt(i) == '+') {
            sign = 1;
            i++;
        } else if(i < n && str.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        int num = 0;
        while(i < n && Character.isDigit(str.charAt(i))) {

            int digit = Character.getNumericValue(str.charAt(i));

            if(num > MAX_INTEGER_DIVIDE10 || (num == MAX_INTEGER_DIVIDE10 && digit >= 8) ) {
                return sign > 0 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
            }

            num = num*10 + digit;
            i++;

        }

        return sign*num;
    }
}