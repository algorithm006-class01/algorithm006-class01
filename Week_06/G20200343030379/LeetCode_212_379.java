package G20200343030379;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 212. 单词搜索 II
 *
 * 给定一个二维网格?board?和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 示例:
 *
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 *
 * 输出:?["eat","oath"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 国外优秀题解：https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
 */



public class LeetCode_212_379 {
    public static void main(String[] args) {
//        char[][] ch={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    }

    /**
     * 执行用时 : 13 ms , 在所有 Java 提交中击败了 82.33% 的用户
     * 内存消耗 : 47.6 MB , 在所有 Java 提交中击败了 37.02% 的用户
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res=new ArrayList<>();
        int n = board.length;
        if(n==0) return res;

        int m = board[0].length;



        //建树
        TreeNode treeNode = buildTree(words);

        //检查单词是否属于前缀树，即单词合法。
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(treeNode,i,j,board,res);
            }
        }
        return res;

    }

    //方向位
    int[][] distances={{-1,0},{1,0},{0,1},{0,-1}};
    //遍历所有关联的结点
    private void dfs(TreeNode root, int i ,int j , char[][] board, List<String> res) {
        char c = board[i][j];
        //是否存在下一个关联结点

        if(board[i][j]=='#' || root.next[c - 'a']==null){
            return;
        }

        TreeNode nextNode = root.next[c - 'a'];
        //找到其中一个单词
        if(nextNode.word!=null){
            res.add(nextNode.word);
            nextNode.word=null;
            //不能退出，还需要继续判断
        }

        board[i][j]='#';
        for (int[] d : distances) {
            int xd=i+d[0];
            int yd=j+d[1];

            if(xd>=0 && yd>=0 && xd<board.length  && yd<board[0].length){
                dfs(nextNode,xd,yd,board,res);
            }
        }
        board[i][j]=c;
    }


    //字符串构建一棵树
    public TreeNode buildTree(String[] words){
        TreeNode root=new TreeNode();
        for (String word : words) {
            TreeNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                //System.out.println(p.next.length);
                if(p.next[index]==null){
                    p.next[index]=new TreeNode();
                }
                p=p.next[index];
            }
            p.word=word;
        }
        return root;
    }

    class TreeNode{
        String word;
        TreeNode[] next=new TreeNode[26];
    }
}
