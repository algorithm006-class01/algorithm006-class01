package G20200343030379;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

/**
 * 557. 反转字符串中的单词 III
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例?1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"?
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 参考优秀题解：
 */
public class LeetCode_557_379 {

    public static void main(String[] args) {
        //十进制转二进制
        //String s = Integer.toBinaryString(-2147483648);
        String[] s = "1       1".split(" ");
        System.out.println(s.length);
        System.out.println(Arrays.toString(s));
        for (String s1 : s) {
            System.out.println(s1+"==="+s1.length());
        }
    }

    /**
     * 工具类反转法
     * 执行用时 : 6 ms , 在所有 Java 提交中击败了 83.13% 的用户
     * 内存消耗 : 40.4 MB , 在所有 Java 提交中击败了 5.75% 的用户
     * 参考：官方题解
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] sp = s.trim().split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < sp.length; i++) {
            sb.append(new StringBuffer(sp[i]).reverse()+" ");
        }
        return sb.toString().trim();
    }

    /**
     * 手动操作法
     * 执行用时 : 3 ms , 在所有 Java 提交中击败了 99.49% 的用户
     * 内存消耗 : 39.9 MB , 在所有 Java 提交中击败了 5.75% 的用户
     * 参考：提交速度代码排行版 https://leetcode-cn.com/submissions/detail/61114549/
     *
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        char[] chars = s.toCharArray();
        int start=0,end=0;
        while (end<s.length()){
            //能用 单引号就不要用双引号，时间复杂度不一样
            end = s.indexOf(' ', start);
            if(end<=0){
                end=s.length();
            }

            resver(chars,start,end-1);
            start=end+1;
        }
        return new String(chars);
    }

    public void resver(char[] c,int i,int j){
        while (i<j){
            char temp=c[i];
            c[i++]=c[j];
            c[j--]=temp;
        }
    }
}