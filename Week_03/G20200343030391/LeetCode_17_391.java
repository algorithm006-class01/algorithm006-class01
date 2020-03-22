package G20200343030391;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode_17_391 {

    public static void main(String[] args) {
        String digits = "23";
        List<String> strings = new LeetCode_17_391().letterCombinations_2(digits);
        System.out.println(strings);
    }
    /**
     * 递归
     * @param digits
     * @return
     */
    public List<String> letterCombinations_1(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        ArrayList<String> result = new ArrayList<>();

        combine("", digits.toCharArray(), 0, result, map);

        return result;
    }

    /**
     * 回溯
     * @param str
     * @param input
     * @param index
     * @param result
     * @param directory
     */
    private void combine(String str, char[] input, int index, List<String> result, HashMap<Character, char[]> directory) {
        //terminator
        if (str.length() == input.length) {
            result.add(str);
            return;
        }
        char[] chars = directory.get(input[index]);

        //process logic
        for (int i = 0; i < chars.length; i++) {
            //drill down
            combine(str + chars[i], input, index + 1, result, directory);
        }

        //reverse
    }

    /**
     * 递归
     * @param digits
     * @return
     */
    public List<String> letterCombinations_2(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        ArrayList<String> result = new ArrayList<>();

        combine_2(new StringBuilder(), digits.toCharArray(), 0, result, map);

        return result;
    }

    /**
     * 回溯
     * @param str
     * @param input
     * @param index
     * @param result
     * @param directory
     */
    private void combine_2(StringBuilder str, char[] input, int index, List<String> result, HashMap<Character, char[]> directory) {
        //terminator
        if (str.length() == input.length) {
            result.add(str.toString());
            return;
        }
        char[] chars = directory.get(input[index]);

        //process logic
        for (int i = 0; i < chars.length; i++) {
            //drill down
            combine_2(str.append(chars[i]), input, index + 1, result, directory);
            str.deleteCharAt(str.length() - 1);
        }

        //reverse
    }
}
