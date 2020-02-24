import java.util.ArrayList;
import java.util.List;

public class LeetCode_22_541 {

    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        dfs(resultList, "", n, n);
        return resultList;
    }


    public void dfs(List<String> resultList, String str, int left, int right) {
        //深度优先搜索，在末尾设置一个返回或者弹出的临界值，然后回溯。
        if (left == 0 && right == 0) {
            resultList.add(str);
        }
        //考虑放入左括号，可以随意放入
        if (left > 0) {
            dfs(resultList, str + '(', left - 1, right);
        }
        //不满足情况的例子都是因为右括号早于左括号放入，因此right必须在left之后放入
        if (right > left) {
            dfs(resultList, str + ')', left, right - 1);
        }
    }


}
