package G20200343030015.week_08;

/**
 * Created by majiancheng on 2020/4/5.
 */
public class LeetCode_151_015 {
    public String reverseWords( String s ){
        char[] chars = new char[s.length()];
        s.getChars(0, s.length(), chars, 0);

        //旋转char[]
        reverseChars(chars);

        //采用flag标记当前状态。
        //当扫描到字符串结尾或空格，且处于单词状态中时，说明扫描到了单词结尾。
        //此时调用reverseWord反转单词
        int start = 0;
        boolean word = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ' && !word) {
                word = true;
                start = i;
            }
            if ((i == chars.length - 1 || chars[i + 1] == ' ') && word) {
                word = false;
                reverseWord(chars,start,i);
            }
        }

        //最后调用removeSpaces方法删除空格并返回新的长度
        return new String(chars, 0, removeSpaces(chars));
    }

    private void reverseChars( char[] chars ){
        char tmp;
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }

    private void reverseWord( char[] chars, int left, int right ){
        char tmp;
        while (left < right) {
            tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
    }

    private int removeSpaces(char[] chars){
        int content = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                if (content != 0) {
                    chars[content++] = ' ';
                }
                while (i < chars.length && (chars[i] != ' ')) {
                    chars[content++] = chars[i++];
                }
            }
        }
        return content;
    }
}
