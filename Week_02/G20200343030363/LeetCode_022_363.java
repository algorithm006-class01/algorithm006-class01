package cn.geek.week2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 所谓递归就是找规律, 找重复子循环
 *
 * @author lemon
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年02月20日 09:08:00
 */
public class LeetCode_022_363 {

    /**
     * Generate parenthesis list. ((()))
     *
     * @param n
     *            the n
     * @return the list
     */
    public List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        generate(resList, "", 0, 0, n);
        return resList;
    }

    /**
     * Generate.
     *
     * @param resList
     *            the res list
     * @param cur
     *            the cur
     * @param left
     *            the left
     * @param right
     *            the right
     * @param max
     *            the max
     */
    public void generate(List<String> resList, String cur, int left, int right, int max) {

        if (cur.length() == max * 2) {
            resList.add(cur);
            return;
        }

        if (left < max) {
            generate(resList, cur + "(", left + 1, right, max);
        }

        if (right < left) {
            generate(resList, cur + ")", left, right + 1, max);
        }
    }

    public static void main(String[] args) {
        LeetCode_022_363 leetcode = new LeetCode_022_363();
        leetcode.generateParenthesis(3).forEach(System.out::println);
    }
}
