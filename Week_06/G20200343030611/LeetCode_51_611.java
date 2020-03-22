package datast.prune;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_51_611 {

    class Solution {

        private List<Integer> col = new ArrayList<>();
        private List<Integer> master = new ArrayList<>();
        private List<Integer> slave = new ArrayList<>();

        private List<List<String>> result = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            List<Integer> res = new ArrayList<>();
            backTrack(0, n, res);
            return result;
        }

        private void backTrack(int rows, int n, List<Integer> res) {
            if (rows == n) {
                print(n, res);
                return;
            }
            for (int i = 0; i < n; i++) {
                if (!col.contains(i) && !master.contains(rows + i)
                        && !slave.contains(rows - i)) {
                    col.add(i);
                    master.add(rows + i);
                    slave.add(rows - i);
                    res.add(i);
                    backTrack(rows + 1, n, res);
                    col.remove(col.size() - 1);
                    master.remove(master.size() - 1);
                    slave.remove(slave.size() - 1);
                    res.remove(res.size() - 1);
                }
            }
        }

        private void print(int n, List<Integer> res) {
            List<String> list = new ArrayList<>();
            for (int i : res) {
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        str.append("Q");
                    } else {
                        str.append(".");
                    }
                }
                list.add(str.toString());
            }
            result.add(list);
        }

    }
}
