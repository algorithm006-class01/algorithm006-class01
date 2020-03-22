import java.util.*; 
/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

// 四连通
// @date Mar 17 2020
// class Solution {
//     int rl, cl;
//     Set<String> res;
//     boolean[][] visited;
//     public List<String> findWords(char[][] board, String[] words) {
//         rl = board.length; 
//         cl = board[0].length;
//         visited = new boolean[rl][cl];
//         res = new HashSet<String>();
//         Trie trie = new Trie();
        
//         for (String s : words) 
//             trie.insert(s);

        // for (int r = 0; r < rl; r ++) 
        //     for (int c = 0; c < cl; c ++)
//                 dfs(board, r, c, trie.root);
//         return new ArrayList<String>(res);
//     }
//     void dfs(char[][] board, int r, int c, TrieNode node) {
//         if (r < 0 || c < 0 || r >= rl || c >= cl || visited[r][c]) 
//             return;
//         node = node.children[board[r][c] - 'a'];
//         if (node == null) 
//             return;
//         if (node.isEnd) 
//             res.add(node.val);
//         visited[r][c] = true;
//         dfs(board, r + 1, c, node);
//         dfs(board, r - 1, c, node);
//         dfs(board, r, c + 1, node);
//         dfs(board, r, c - 1, node);
//         visited[r][c] = false;
//     }

//     class Trie {
//         public TrieNode root = new TrieNode();
//         public void insert(String str) {
//             TrieNode node = root;
//             for (char c : str.toCharArray()) {
//                 if (node.children[c - 'a'] == null) 
//                     node.children[c - 'a'] = new TrieNode();
//                 node = node.children[c - 'a'];
//             }
//             node.isEnd = true;
//             node.val = str;
//         }
//     }
//     class TrieNode {
//         public String val;
//         public TrieNode[] children;
//         public boolean isEnd = false;
//         TrieNode() {
//             children = new TrieNode[26];
//         }
//     }
// }

// @lc code=start
// @date Mar 19 2020
// @solution trie
class Solution {
    int rl, cl;
    Set<String> res;
    boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        rl = board.length;
        cl = board[0].length;
        res = new HashSet<>();
        Trie trie = new Trie();
        
        for (String s: words)
            trie.insert(s);

        for (int r = 0; r < rl; r ++) {
            for (int c = 0; c < cl; c ++) {
                dfs(board, r, c, trie.root);
            }
        }
        return new ArrayList<String>(res);
    }

    void dfs(char[][] board, int r, int c, TrieNode node) {
        if (r < 0 || c < 0 || r >= rl || c >= cl || board[r][c] == '\0')
            return;
        node = node.children[board[r][c] - 'a'];
        if (node == null) 
            return;
        if (node.isEnd)
             res.add(node.val);

        char tmp = board[r][c];
        board[r][c] = '\0';
        dfs(board, r + 1, c, node);
        dfs(board, r - 1, c, node);
        dfs(board, r, c + 1, node);
        dfs(board, r, c - 1, node);
        board[r][c] = tmp;
    }

    class Trie {
        public TrieNode root = new TrieNode();
        public void insert (String str) {
            TrieNode node = root;
            for(char c : str.toCharArray()) {
                if (node.children[c - 'a'] == null)
                    node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
            node.val = str;
        }
    }
    class TrieNode {
        public String val;
        public TrieNode[] children;
        public boolean isEnd = false;
        TrieNode() {
            children = new TrieNode[26];
        }
    }
}
// @lc code=end

