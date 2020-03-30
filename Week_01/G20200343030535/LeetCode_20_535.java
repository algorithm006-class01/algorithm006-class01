package leetcode.Week01;

import java.util.HashMap;
import java.util.Stack;

public class LeetCode_20_535 {
    /**
     * 题目： 有效的括号问题
     *给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     *
     * 输入: "()"
     * 输出: true
     * 示例 2:
     *
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     *
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     *
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     *
     * 输入: "{[]}"
     * 输出: true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 思路1：暴力法  不断地replace匹配的括号->""
     * //a.()[]{}       只需要扫一次
     * //b.(({[]}))）   最多要扫n^2
     * 时间复杂度为 o(n^2)
     * 思路2:栈
     * 什么样的问题可以使用栈来解决呢？洋葱型
     * 具有所谓的最近相关性的问题
     * （从外到内，从内到外，逐渐扩散，而且最外层和最内层是一对）
     */

    /**
     * 技巧性
     */
    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            /**遇到左括号的处理*/
            if (c == '{'){
                stack.push('}');
            }else if (c == '('){
                stack.push(')');
            }else if (c == '['){
                stack.push(']');
            }else if (stack.empty() || stack.pop() != c){
                /**遇到右括号的处理**/
                /**如果存储右括号栈为空：说明没有右括号和c进行匹配了
                 * 如果存储右括号栈顶元素没有和c能够匹配的，说明是无效的括号
                 * */
                return false;
            }
        }
        /**
         * 如果字符串中的元素已经遍历完成，存储右括号的栈为空，则是有效的字符串。
         * 如果栈不为空，则是无效的字符串
         */
        return stack.empty();
    }

    private HashMap<Character,Character> mappings;

    public LeetCode_20_535(){
        this.mappings = new HashMap<>();
        this.mappings.put(')','(');
        this.mappings.put('}','{');
        this.mappings.put(']','[');
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.mappings.containsKey(c)){
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != this.mappings.get(c));{
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
