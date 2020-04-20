package G20200343030379;

import javafx.concurrent.Worker;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 151. 翻转字符串里的单词
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * ?
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出:?"blue is sky the"
 * 示例 2：
 *
 * 输入: " ?hello world! ?"
 * 输出:?"world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good ? example"
 * 输出:?"example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * ?
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 方法1：拆分，反转，组合
 * 方法2：反转这个字符串，单独反转每个单词
 * 参考优秀题解：官方题解
 */
public class LeetCode_151_379 {

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
     * 执行用时 : 7 ms , 在所有 Java 提交中击败了 42.16% 的用户
     * 内存消耗 : 40 MB , 在所有 Java 提交中击败了 5.15% 的用户
     * 参考：官方
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        String[] split = s.split(" +");
        Collections.reverse(Arrays.asList(split));
        return String.join(" ",split);
    }

    /**
     * 双端队列
     * 执行用时 : 7 ms , 在所有 Java 提交中击败了 42.16% 的用户
     * 内存消耗 : 39.9 MB , 在所有 Java 提交中击败了 5.15% 的用户
     * 参考：官方
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        s=s.trim();

        int left=0,right=s.length()-1;
        Deque<String> deque=new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();

        while (left<=right){
            char c = s.charAt(left);
            if(c!=' '){
                sb.append(c);
            }else if(c==' ' && sb.length()!=0){
                deque.addFirst(sb.toString());
                sb.setLength(0);
            }

            left++;
        }
        deque.addFirst(sb.toString());

        return String.join(" ",deque);
    }


    /**
     * 倒叙输出，不涉及集合，只用数组，效果更快
     *
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 39.7 MB , 在所有 Java 提交中击败了 5.15% 的用户
     * 参考：参考排行榜题解
     * @param s
     * @return
     */
    public String reverseWords3(String s) {
        s=s.trim();
        //使用正则表达式，效率会慢一丢丢
        //String[] split = s.split(" +");
        String[] split = s.split(" ");
        StringBuilder sb=new StringBuilder();

        for (int i = split.length-1; i >=0; i--) {
            if(!split[i].equals("")){
                sb.append(split[i]).append(' ');
            }
        }

        return sb.toString().trim();
    }
}