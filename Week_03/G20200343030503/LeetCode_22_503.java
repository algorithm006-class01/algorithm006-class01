/**
 *
 * 算法重点: 如果我们还剩一个位置，我们可以开始放一个左括号。 如果它不超过左括号的数量，我们可以放一个右括号。
 *
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,"",0,0,n);
        return result;
    }

    public void backtrack(List<String> result,String cur,int open,int close,int max) {
        //termination
        if (cur.length() == max*2) {
            result.add(cur);
            return;
        }
        //process

        //drill down
        if (open < max) {
            backtrack(result,cur+"(",open + 1,close,max);
        }
        if (close < open) {
            backtrack(result,cur+")",open,close+1,max);
        }
        //reverse state

    }
}