package G20200343030015.week_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by majiancheng on 2020/2/23.
 */
public class LeetCode_77_015 {

    List<List<Integer>> result = new ArrayList<>();

    //循环遍历+迭代遍历，判断
    public List<List<Integer>> combine(int n, int k) {
        helper(n, k, 1, new Stack<Integer>());

        return result;
    }

    public void helper(int n, int k, int begin, Stack<Integer> val) {
        if (val.size() == k) {
            result.add(new ArrayList<>(val));
            return;
        }

        //每次进入下一个循环 i+1
        for (int i = begin; i <= n - (k - val.size()) + 1; i++) {
            val.push(i);
            //迭代添加之后的元素
            helper(n, k, i + 1, val);
            val.pop();
        }
    }

}
