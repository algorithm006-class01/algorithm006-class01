package G20200343030379;

import java.util.Arrays;
import java.util.Stack;

/**
 * 917. 仅仅反转字母
 *
 * 给定一个字符串?S，返回?“反转后的”?字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 * ?
 *
 * 示例 1：
 *
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 * ?
 *
 * 提示：
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122?
 * S 中不包含?\ or "
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解题方法：
 *  1、栈法
 *  2、反向指针
 *
 * 参考优秀题解：
 */
public class LeetCode_917_379 {

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
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 31.12% 的用户
     * 内存消耗 : 38.2 MB , 在所有 Java 提交中击败了 6.45% 的用户
     * @param S
     * @return
     */
    public String reverseOnlyLetters(String S) {
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(Character.isLetter(c)){
                stack.push(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(Character.isLetter(c)){
                sb.append(stack.pop());
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 反向指针
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 83.51% 的用户
     * 内存消耗 : 37.8 MB , 在所有 Java 提交中击败了 6.45% 的用户
     * @param S
     * @return
     */
    public String reverseOnlyLetters2(String S) {
         StringBuilder sb=new StringBuilder();
         int j= S.length()-1;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(Character.isLetter(c)){
                //排除非字母
                while(!Character.isLetter(S.charAt(j))){
                    j--;
                }
                sb.append(S.charAt(j--));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

}