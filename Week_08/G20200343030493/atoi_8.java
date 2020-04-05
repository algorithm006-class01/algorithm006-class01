class Solution {
    public int myAtoi(String str) {
        if(str==null || str.length()<=0) return 0;
        //正负数的最大最小值
        int MAX=Integer.MAX_VALUE,MIN=Integer.MIN_VALUE;
        int res=0,index=0;
        //过滤空格
        while(index<str.length()&&str.charAt(index)==' ')index++;
        if(index==str.length()) return 0;
        //取正负号
        char firstChar=str.charAt(index);
        boolean positive=true;
        if(!isDigit(firstChar)){
            if(firstChar!='+'&&firstChar!='-') return 0;
            index++;
            positive = firstChar!='-';
        }
        //用负数保存正负数的边界，这样不会溢出
        //正数 -2147483647
        //负数 -2147483648
        int limit=positive?-MAX:MIN;
        //过滤0
        while(index<str.length()&&str.charAt(index)=='0')index++;
        //取每一位,在非字符截止
        while(index<str.length()&&isDigit(str.charAt(index))){
            int digit=str.charAt(index++)-'0';
            if(res<(limit+digit)/10){
                return positive?MAX:MIN;
            }
            //这里的res>=limit
            res=res*10-digit; //用减法
        }
        return positive?-res:res;
    }

    public boolean isDigit(char c){
        return c>='0' && c<='9';
    }
}