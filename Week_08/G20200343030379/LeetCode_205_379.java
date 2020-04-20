package G20200343030379;

import java.util.Arrays;
import java.util.Stack;

/**
 * 205. 同构字符串
 *
 * 给定两个字符串?s?和?t，判断它们是否是同构的。
 *
 * 如果?s?中的字符可以被替换得到?t?，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设?s?和 t 具有相同的长度。
 *
 * 通过次数33,919提交次数71,797
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 参考优秀题解：
 *  1、（先看下面两个代码的原理解释：中文）
 *      https://leetcode-cn.com/problems/isomorphic-strings/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-42/
 *  2、https://leetcode.com/problems/isomorphic-strings/discuss/57796/My-6-lines-solution
 *  3、https://leetcode.com/problems/isomorphic-strings/discuss/57810/Short-Java-solution-without-maps
 *
 *
 *
 */
public class LeetCode_205_379 {

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
     * 执行用时 : 5 ms , 在所有 Java 提交中击败了 92.90% 的用户
     * 内存消耗 : 40.1 MB , 在所有 Java 提交中击败了 5.26% 的用户
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        int[] m=new int[256];
        int[] n=new int[256];

        for (int i = 0; i < s.length(); i++) {
            char l = s.charAt(i);
            char r = t.charAt(i);
            //当前的映射值是否相同
            if(m[l]!=n[r]){
                return false;
            }else{
                //是否已经修改过，修改过就不需要再处理
                if(m[l]==0){
                    m[l]=i+1;
                }
                if(n[r]==0){
                    n[r]=i+1;
                }
            }
        }

        return true;
    }

}