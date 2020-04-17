package G20200343030379;

import java.util.HashMap;
import java.util.Map;

/**
 * 541. 反转字符串 II
 *
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符
 * ，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 *
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * 要求:
 *
 * 该字符串只包含小写的英文字母。
 * 给定字符串的长度和 k 在[1, 10000]范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：
 *  1、暴力法
 *  2、
 *
 * 参考优秀题解：
 */
public class LeetCode_541_379 {

    public static void main(String[] args) {
        //十进制转二进制
        //String s = Integer.toBinaryString(-2147483648);
        new LeetCode_541_379().reverseStr("abcdefg",2);
    }

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 97.69% 的用户
     * 内存消耗 : 40 MB , 在所有 Java 提交中击败了 5.97% 的用户
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int start=0;
        for (int i = 0; i < chars.length; i=i+2*k) {
            //int end=chars.length>i+k-1?i+k-1:chars.length-1;
            //优雅写法
            int end=Math.min(i+k-1,chars.length-1);
            start=i;

            while (end>start){
                char temp=chars[end];
                chars[end]=chars[start];
                chars[start]=temp;
                start++;
                end--;
            }
        }

        return new String(chars);


    }


    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 97.73% 的用户
     * 内存消耗 : 39.7 MB , 在所有 Java 提交中击败了 6.35% 的用户
     * @param s
     * @param k
     * @return
     */
    public String reverseStr2(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i=k*2+i) {
            int start=i;
            int end=Math.min(chars.length-1,k+i-1);

            while (start<end){
                char temp=chars[end];
                chars[end--]=chars[start];
                chars[start++]=temp;
            }
        }
        return new String(chars);
    }

}