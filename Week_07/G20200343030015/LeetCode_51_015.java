package G20200343030015.week_07;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by majiancheng on 2020/3/29.
 *
 * 51. N皇后
 */
public class LeetCode_51_015 {
    List<List<String>> res = new ArrayList<List<String>>();

    int flag = 0;

    public List<List<String>> solveNQueens(int n) {
        if(n == 0) return res;

        flag = (flag << n) - 1;
        Stack<Integer> stack = new Stack<Integer>();
        helper(stack, 0, 0, 0, n, 0);

        return res;
    }

    public void helper(Stack<Integer> stack, int col, int master, int slave, int n, int row) {
        if(stack.size() == n) {
            res.add(generQueen(stack));

            return;
        }

        for(int i = 0; i < n; i++) {
            //判断是否没有冲突
            if(((col >> i) & 1) == 0 && ((master >> (row + i)) & 1) == 0 && ((slave >> (row - i + n - 1)) & 1) == 0) {
                col ^= (1 << i);
                master ^= (1 << (row + i));
                slave ^= (1 << (row - i + n - 1));

                //处理当前层逻辑
                stack.push(i);
                helper(stack, col, master, slave, n, row + 1);

                col ^= (1 << i);
                master ^= (1 << (row + i));
                slave ^= (1 << (row - i + n - 1));
                stack.pop();
            }
        }

    }

    public List<String> generQueen(Stack<Integer> stack) {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<stack.size(); i++) {
            sb.append('.');
        }

        List<String> result = new ArrayList<String>();
        String queenStr = sb.toString();
        for(int index : stack) {
            result.add(sb.substring(0, index) + "Q" + sb.substring(index + 1));
        }

        return result;
    }
}
