// leetcode212 单词搜索II
// trie前缀树 + DFS
// 1. 改造TrieNode，增加存储字符串的val，减少字符串拼接的开销
// 2. 增加布尔型visited的辅助数组，判断该字符是否已经被使用，减少字符串比较的开销
// 时间复杂度O(N + m*n*4^k)
class Solution {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    boolean[][] visited;
    Set<String> res = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board[0] == null) return new ArrayList<>();

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        // DFS
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, trie.root);
            }
        }

        return new LinkedList<>(res);
    }

    private void dfs(char[][] board, int i, int j, TrieNode root) {
        char ch = board[i][j];
        TrieNode node = root.get(ch);
        if (node == null) return;

        if (node.isEnd()) {
            res.add(node.val);
        }

        // used
//        board[i][j] = '@';
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x < 0 || x == board.length || y < 0 || y == board[0].length || visited[x][y])
                continue;
            dfs(board, x, y, node);
        }
        // reset
//        board[i][j] = ch;
        visited[i][j] = false;
    }
}

class TrieNode {
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public String val;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {
    public TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if (!node.containsKey(curChar)) {
                node.put(curChar, new TrieNode());
            }
            node = node.get(curChar);
        }
        node.setEnd();
        node.val = word;
    }
}