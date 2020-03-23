package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * #### [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/)
 * 递归
 */
public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        generate(0, 0, n, "", list);
        return list;
    }


    private static void generate(int left, int right, int n, String s, ArrayList<String> list) {
        //        递归终结条件
        if (left == n && right == n) {
            list.add(s);
        }
        //        当前层逻辑
        String s1 = s + "(";
        String s2 = s + ")";
        //        进入下一层
        if (left < n) {
            generate(left + 1, right, n, s1, list);
        }
        if (right < left) {
            generate(left, right + 1, n, s2, list);
        }
        //        清理当前层
    }


    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
