package com.aizain.jhome.computer.data.recursive;

import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * GenerateParenthesis
 * 22. 括号生成
 * <p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Zain
 * @date 2020/3/1
 */
public class GenerateParenthesis {

    private static Map<String, String> doubleMap = new HashMap<>(3);

    static {
        doubleMap.put("(", ")");
        doubleMap.put("?", "?");
    }

    private List<String> result = new LinkedList<>();

    /**
     * 审题：
     * 1 有效的小括号组合
     * 2 需要判断n边界
     * 3 n是括号对的数量
     * <p>
     * 思路：
     * 1 无思路，看题解
     * 2 分治、回溯：左括号、右括号
     * <p>
     * 反馈：
     * 1 回溯（深度优先）
     * 2 广度优先
     * 3 动态规划
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        // return recursiveSolution(n);
        // return backtrackSolution(n);
        return backtrackCleanSolution(n);
    }

    /**
     * 回溯法简洁版
     * 1 ms	39.4 MB
     *
     * @param n
     * @return
     */
    private List<String> backtrackCleanSolution(int n) {
        return backtrackCleanGenerate("(", n - 1, n);
    }

    private List<String> backtrackCleanGenerate(String line, int left, int right) {
        if (left > 0) {
            backtrackCleanGenerate(line + "(", left - 1, right);
        }
        if (right > left) {
            backtrackCleanGenerate(line + ")", left, right - 1);
        }
        if (right <= 0) {
            result.add(line);
        }
        return result;
    }

    /**
     * 递归分治回溯法：左括号数小于n，右括号数小于左括号数
     * <p>
     * 1 ms	39.4 MB
     *
     * @param n
     * @return
     */
    private List<String> backtrackSolution(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }
        List<String> result = new LinkedList<>();
        backtrackGenerate(result, "(", 1, 0, n);
        return result;
    }

    private void backtrackGenerate(List<String> result, String line, int left, int right, int max) {
        // 1 终止条件
        if (line.length() == max * 2) {
            result.add(line);
            return;
        }
        // 2 当前层
        // 3 子问题
        if (left < max) {
            backtrackGenerate(result, line + "(", left + 1, right, max);
        }
        if (right < left) {
            backtrackGenerate(result, line + ")", left, right + 1, max);
        }
        // 4 合并
        // 5 清理
    }

    /**
     * 暴力递归：找出所有可能性，过滤掉不合适的
     * 102 ms	42.1 MB
     *
     * @param n
     * @return
     */
    private List<String> recursiveSolution(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }

        List<String> result = new LinkedList<>();
        recursiveGenerate("(", n * 2, result);

        return result;
    }

    private void recursiveGenerate(String line, int max, List<String> result) {
        // 1 递归终结条件
        if (line.length() == max) {
            if (valid(line)) {
                result.add(line);
            }
            return;
        }
        // 2 准备数据，处理当前层
        String l1 = line + "(";
        String l2 = line + ")";
        // 3 下探处理子问题
        recursiveGenerate(l1, max, result);
        recursiveGenerate(l2, max, result);
        // 4 合并子问题结果
        // 5 清理
    }

    private boolean valid(String line) {
        Deque<String> stack = new LinkedList<>();
        stack.push("?");
        line += "?";
        for (String one : line.split("")) {
            String pop = stack.peek();
            if (one.equals(pop)) {
                stack.pop();
            } else {
                stack.push(doubleMap.get(one));
            }
        }
        return stack.isEmpty();
    }

}
