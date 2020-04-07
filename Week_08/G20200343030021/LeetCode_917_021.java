package string;

//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
//
//
//
//
//
//
// 示例 1：
//
// 输入："ab-cd"
//输出："dc-ba"
//
//
// 示例 2：
//
// 输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
//
//
// 示例 3：
//
// 输入："Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
//
//
//
//
// 提示：
//
//
// S.length <= 100
// 33 <= S[i].ASCIIcode <= 122
// S 中不包含 \ or "
//
// Related Topics 字符串


/**
 * 917.reverse-only-lettTers
 * 仅仅反转字母
 */
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        ReverseOnlyLetters solution = new ReverseOnlyLetters();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseOnlyLetters(String S) {
            StringBuilder ans = new StringBuilder();
            int j = S.length() - 1;
            for (int i = 0; i < S.length(); ++i) {
                if (Character.isLetter(S.charAt(i))) {
                    while (!Character.isLetter(S.charAt(j)))
                        j--;
                    ans.append(S.charAt(j--));
                } else {
                    ans.append(S.charAt(i));
                }
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}