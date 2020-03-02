package G20200343030391;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_22_391 {

    public static void main(String[] args) {
        int n = 3;
        List<String> strings = new LeetCode_22_391().generateParenthesis(n);
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("", result, n, n);
        return result;
    }

    /**
     * 递归剪枝
     *
     * @param str
     * @param result
     * @param left
     * @param right
     */
    private void generate(String str, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }
        if (left > 0) {
            generate(str + "(", result, left - 1, right);
        }
        if (right > left) {
            generate(str + ")", result, left, right - 1);
        }
    }

}
