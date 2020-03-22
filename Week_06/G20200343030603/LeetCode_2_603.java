//1. words 遍历 --> board search O(N * m * m * 4 ^k)

class Solution {
     public List<String> findWords(char[][] board, String[] words) {
        //构建字典树
        wordTrie myTrie=new wordTrie();
        trieNode root=myTrie.root;
        for(String s:words)
            myTrie.insert(s);

        //使用set防止重复
        Set<String> result =new HashSet<>();
        int m=board.length;
        int n=board[0].length;
        boolean [][]visited=new boolean[m][n];
        //遍历整个二维数组
        for(int i=0;i<board.length; i++){
            for (int j = 0; j < board [0].length; j++){
                find(board,visited,i,j,m,n,result,root);
            }
        }
        System.out.print(result);
        return new LinkedList<String>(result);
    }
    private void find(char [] [] board, boolean [][]visited,int i,int j,int m,int n,Set<String> result,trieNode cur){
        //边界以及是否已经访问判断
        if(i<0||i>=m||j<0||j>=n||visited[i][j])
            return;
            //获取子节点状态，判断其是否有子节点
        cur=cur.child[board[i][j]-'a'];
        //修改节点状态，防止重复访问
        visited[i][j]=true;
        if(cur==null)
        {
            //如果单词不匹配，回退
            visited[i][j]=false;
            return;
        }
        //找到单词加入
        if(cur.isLeaf)
        {
            result.add(cur.val);
            //找到单词后不能回退，因为可能是“ad” “addd”这样的单词得继续回溯
//            visited[i][j]=false;
//            return;
        }
        find(board,visited,i+1,j,m,n,result,cur);
        find(board,visited,i,j+1,m,n,result,cur);
        find(board,visited,i,j-1,m,n,result,cur);
        find(board,visited,i-1,j,m,n,result,cur);
        //最后要回退，因为下一个起点可能会用到上一个起点的字符
        visited[i][j]=false;
    }


}

//字典树
class wordTrie{
    public trieNode root=new trieNode();
    public void insert(String s){
        trieNode cur=root;
        for(char c:s.toCharArray()){
            //判断是否存在该字符的节点，不存在则创建
            if(cur.child[c-'a']==null){
                cur.child [c-'a'] = new trieNode();
                cur=cur.child[c-'a'];
            }else
                cur=cur.child [c-'a'];
        }
        //遍历结束后，修改叶子节点的状态，并存储字符串
        cur.isLeaf=true;
        cur.val=s;
    }
}
//字典树结点
class trieNode{
    public String val;
    public trieNode[] child=new trieNode[26];
    public boolean isLeaf=false;

    trieNode(){

    }
}