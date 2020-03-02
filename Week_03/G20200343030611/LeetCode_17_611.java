package datast.divide_backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_17_611 {

    private static Map<Character, String> map = new HashMap<>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if ("".equals(digits)) {
            return res;
        }
        generate(digits, 0, res, "");
        return res;
    }

    public void generate(String digits, int index, List res, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        String alphabet = map.get(digits.charAt(index));
        int nextIndex = index + 1;
        for (int i = 0; i < alphabet.length(); i++) {
            char a = alphabet.charAt(i);
            generate(digits, nextIndex, res, s + String.valueOf(a));
        }
    }
}
