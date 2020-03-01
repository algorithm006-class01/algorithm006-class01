package datast.divide_backtrack;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_51_611 {

    private List<Integer> col = new ArrayList<>();
    private List<Integer> master = new ArrayList<>();
    private List<Integer> slave = new ArrayList<>();

    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<Integer> res = new ArrayList<>();
        backTrace(0, res, n);
        return result;
    }

    private void backTrace(int row, List res, int n) {
        if (row == n) {
            print(res, n);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !master.contains(row + i) && !slave.contains(row - i)) {
                res.add(i);
                col.add(i);
                master.add(row + i);
                slave.add(row - i);
                backTrace(row + 1, res, n);
                slave.remove(slave.size() - 1);
                master.remove(master.size() - 1);
                col.remove(col.size() - 1);
                res.remove(res.size() - 1);
            }
        }
    }

    private void print(List<Integer> res, int n) {
        List<String> list = new ArrayList<>();


        for (int i = 0; i < res.size(); i++) {
            StringBuilder stb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                stb.append(".");
            }
            list.add(stb.replace(res.get(i), res.get(i) + 1, "Q").toString());
        }
        result.add(list);
    }
}
