import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路: 动态规划思路，假定前n-1个已稳定生产，则第n对时候可考虑的位置
 * F(0) ""
 * F(1) ()
 * F(2) ()() (())
 * F(3) ()()() (())() ()(()) (()()) ((()))
 * 时间复杂度:
 * 空间复杂度:
 * 执行用时: 2 ms, 在所有 Java 提交中击败了54.10%的用户
 * 内存消耗: 39.5 MB, 在所有 Java 提交中击败了5.16%的用户
 * @Author: loe881@163.com
 * @Date: 2020/3/22
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<List<String>> result = new ArrayList<>();
        if (0 == n){
            return result.get(0);
        }
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        List<String> dp1 = new ArrayList<>();
        dp1.add("()");
        result.add(dp0);
        result.add(dp1);
        for (int i = 2; i <= n; i++) {
            List<String> tmpList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> dpK = result.get(j);
                List<String> dpO = result.get(i - 1 - j);
                for (String dpk : dpK) {
                    for (String dpo : dpO) {
                        String tmpStr = "(".concat(dpk).concat(")").concat(dpo);
                        tmpList.add(tmpStr);
                    }
                }
            }
            result.add(tmpList);
        }
        return result.get(n);
    }
}
