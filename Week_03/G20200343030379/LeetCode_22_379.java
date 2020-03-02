package G20200343030379;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 22. 括号生成
 * 给出?n?代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出?n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class LeetCode_22_379 {
    public static void main(String[] args) {
        List<String> strings = new LeetCode_22_379().generateParenthesis2(3);
        System.out.println(strings);


    }

    /**
     * 递归法-->深度优先搜索 DFS
     */
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        dfs(res,n,n,n*2,"");
        return res;
    }

    /**
     *
     * @param res 结果集
     * @param left 左边有多少个左括号
     * @param right 右边有多少个右括号
     * @param n 总的个数，用于判断是否结束
     * @param curStr 当前处理字符串
     */
    private void dfs(List<String> res, int left, int right, int n, String curStr) {
        //结束条件
        if(curStr.length()==n){
            res.add(curStr);
            return ;
        }

        //左边的括号已经用完，每次左括号减1：left-1
        if(left>0){
            dfs(res,left-1,right,n,curStr+"(");
        }
        //右边的括号已经用完,并且必须存在有使用左括号的情况(left<right)，每次右括号减1：right-1
        if(right>0 && left<right){
            dfs(res,left,right-1,n,curStr+")");
        }

    }



    /**
     * 队列遍历法-->广度优先搜索 BFS
     * 因为不是递归调用，没办法利用队列传递多个参数，为了方便遍历，自己建立一个结点结构，用于上下文可以获取对应的值，
     *  例如：1、当前字符串 2、左括号数量 3、右括号数量，
     *
     *  参考题解：https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
     */

    class Node {
        /**
         * 当前得到的字符串
         */
        private String res;
        /**
         * 剩余左括号数量
         */
        private int left;
        /**
         * 剩余右括号数量
         */
        private int right;

        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis2(int n) {
        List<String> res=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        queue.add(new Node("",n,n));

        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(node.left==0 && node.right==0){
                res.add(node.res);
            }

            if(node.left>0){
                queue.offer(new Node(node.res+"(",node.left-1,node.right));
            }
            if(node.right>0 && node.left<node.right){
                queue.offer(new Node(node.res+")",node.left,node.right-1));
            }
        }
        return res;

    }

}
