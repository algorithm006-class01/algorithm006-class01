class Solution {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        int idx = 0;
        while(idx<len && chars[idx]==' '){
            idx++;
        }
        if(idx==len){
            return 0;
        }
        boolean negative = false;
        if(chars[idx]=='-'){
            negative = true;
            idx++;
        }else if(chars[idx]=='+'){
            idx++;
        }else if(!Character.isDigit(chars[idx])){
            return 0;
        }
        int ans = 0;
        while(idx<len && Character.isDigit(chars[idx])){
            int digit = chars[idx] - '0';
            if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && digit>7)){
                return negative? Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            ans = ans*10 + digit;
            idx ++;
        }
        return negative? -ans : ans;
    }
}
