package G20200343030379;

import java.util.Arrays;
import java.util.Stack;

/**
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * 解题方法：
 *    反向指针
 *
 * 参考优秀题解：
 * https://leetcode.com/problems/valid-palindrome-ii/discuss/107714/Java-solution-isPalindrome
 * https://leetcode.com/problems/valid-palindrome-ii/discuss/107716/Java-O(n)-Time-O(1)-Space
 */
public class LeetCode_680_379 {

    public static void main(String[] args) {
    }

    /**
     * 执行用时 : 9 ms , 在所有 Java 提交中击败了 75.51% 的用户
     * 内存消耗 : 40.2 MB , 在所有 Java 提交中击败了 6.67% 的用户
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int l=0,r=s.length()-1;
        //匹配相同，不断往中间逼近
        while(l<r && s.charAt(l)==s.charAt(r)){
            l++;
            r--;
        }

        //结束则返回
        if(l>=r){
            return true;
        }

        //没有结束的删掉其中一个
        return isPalin(s,l+1,r) || isPalin(s,l,r-1);

    }

    private boolean isPalin(String s, int l, int r) {
        while (l<r){
            if(s.charAt(l)==s.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }


    /**
     * 执行用时 : 7 ms , 在所有 Java 提交中击败了 94.76% 的用户
     * 内存消耗 : 40.3 MB , 在所有 Java 提交中击败了 6.67% 的用户
     * @param s
     * @return
     */
    public boolean validPalindrome2(String s) {
        char[] chars = s.toCharArray();
        int l=0,r=s.length()-1;
        //匹配相同，不断往中间逼近
        while(l<r && chars[l]==chars[r]){
            l++;
            r--;
        }

        //结束则返回
        if(l>=r){
            return true;
        }

        //没有结束的删掉其中一个
        return isPalin2(chars,l+1,r) || isPalin2(chars,l,r-1);

    }

    private boolean isPalin2(char[] chars, int l, int r) {
        while (l<r){
            if(chars[l]==chars[r]){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }

}