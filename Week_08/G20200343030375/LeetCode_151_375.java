package G20200343030375;

public class LeetCode_151_375 {
    public  String reverseWords(String s) {
        if(s == null||"".equals(s)){
            return s;
        }

        String[] strArray =  s.split(" ");
        StringBuilder strb = new StringBuilder();
        for(int i = strArray.length -1;i >=0 ; i--)
            if(!"".equals(strArray[i])) strb.append(strArray[i]).append(" ");

        // strb.deleteCharAt(strb.length()-1);
        return strb.toString().trim();

    }
    public static void main(String[] args){
        LeetCode_151_375 bean = new LeetCode_151_375();
        System.out.println(bean.reverseWords("a good   example"));
    }
}
