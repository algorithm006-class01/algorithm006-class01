import java.util.*;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// 递归
// @date Feb 20 2020
// class Solution {
//     private List<String> ans;

//     public List<String> generateParenthesis(int n) {
//         ans = new ArrayList<String>();
//         addParenthesis(0, 0, n, "");
//         return ans;
//     }

//     private void addParenthesis(int left, int right, int max, String str) {
//         // terminator
//         if (left == max && right == max){
//             ans.add(str);
//             return;
//         }
//         if (left + 1 <= max)
//             addParenthesis(left + 1, right, max, str + "(");
//         if (right < left)
//             addParenthesis(left, right + 1, max, str + ")");
//     }
// }

// dfs
// @date Mar 05 2020
// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> res = new ArrayList<>();
//         dfs(res, 0, 0, n, "");
//         return res;
//     }
//     void dfs(List<String> res, int l, int r, int n, String s){
//         if (l == n && r == n){
//             res.add(s);
//             return;
//         }    
//         if (l < n) 
//             dfs(res, l + 1, r, n, s + "(");
//         if (r < l)
//             dfs(res, l, r + 1, n, s + ")");
//     }
// }

// bfs
// @date Mar 05 2020
// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> res = new ArrayList<>();
//         if (n == 0) return res;
//         Queue<String> queue = new LinkedList<>();
//         queue.offer("");
//         while(!queue.isEmpty()) {
//             String str = queue.poll();
//             char[] arr = str.toCharArray();
//             int left = 0, right = 0;
//             for (char c: arr) {
//                 if (c == '(') left++;
//                 if (c == ')') right++;
//             }
//             if (left == n && right == n) {
//                 res.add(str);
//             }
            
//             if (left < n) {
//                 queue.offer(str + "(");
//             }
//             if (right < left) {
//                 queue.offer(str + ")");
//             }
//         }
//         return res;
//     }
// }

// @lc code=start
// @date Mar 22 2020
// @solution backtracking
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, "", 0, 0);
        return res;
    }
    void dfs(int n, String str, int l, int r) {
        if (l == n && r == n) {
            res.add(str);
            return;
        }
        if (l < n)
            dfs(n, str + "(", l + 1, r);
        if (r < l)
            dfs(n, str + ")", l, r + 1);
    }
}
// @lc code=end
