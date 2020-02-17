
class Solution {

    private static final Integer CACHE_NUMBER = 3;

    public static Map<Character, Character> cache = new HashMap<>(CACHE_NUMBER);

    /**
     * 题目名称：有效的括号
     * 思路解析：
     * 1、先把所有右括号当做key放入 哈希表中
     * 2、判断是否是左括号 是则入栈，不是则表示是不合法的括号
     * 3、判断是否为右括号，如果是右括号，则与栈顶元素匹配出栈，不是则为非法括号
     * 4、最后如果循环完成，栈为空则表示所有扩好都匹配上了
     *
     * @param nums
     * @return
     */
    public boolean isValid(String s) {
        cache.put('}', '{');
        cache.put(')', '(');
        cache.put(']', '[');
        Stack<Character> stack = new Stack();
        for (Character item : s.toCharArray()) {
            // 先判断左括号 如果加入的是左括号 则可以加入 是右括号 则是不正确的
            if (!cache.containsKey(item)) {
                stack.push(item);
                // 判断是否栈为空或者栈顶元素与当前存放的元素无法匹配 则为不和发括号组合
            } else if (stack.isEmpty() || stack.pop() != cache.get(item)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 国际站java解法
     * @return
     */
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack();
        for (Character item : s.toCharArray()) {
            if (item=='(') {
                stack.push(")");
            } else if (item=='[') {
                stack.push("]");
            } else if (item=='{') {
                stack.push("}");
            } else if (stack.isEmpty() || stack.pop() != item) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}



