import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(0,0,n,"");
        return res;
    }

    public void generate(int left,int right,int n, String s){
        if(left == n && right == n){
            res.add(s);
            return;
        }
        //当前逻辑
        String s1 = s + "(";
        String s2 = s + ")";
        //下探下一层
        if(left < n){
            generate(left + 1,right,n,s1);
        }
        if(right < left){
            generate(left,right+1,n,s2);
        }
    }
}