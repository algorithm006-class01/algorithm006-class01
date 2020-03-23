package dynamic;

/**
 * https://leetcode-cn.com/problems/word-search-ii/
 */
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        //把words放到Trie里
        for (String word : words) {
            trie.insert(word);
        }

        //遍历board
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Set<String> result = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                fun(trie, "", board, i, j, visited, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void fun(Trie trie, String str, char[][] board, int i, int j, boolean[][] visited, Set<String> result) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }

        if (visited[i][j]) {
            return;
        }

        str += board[i][j];
        if (!trie.startsWith(str)) {
            return;
        }

        if (trie.search(str)) {
            result.add(str);
        }

        visited[i][j] = true;
        fun(trie, str, board, i, j + 1, visited, result);
        fun(trie, str, board, i, j - 1, visited, result);
        fun(trie, str, board, i + 1, j, visited, result);
        fun(trie, str, board, i - 1, j, visited, result);
        visited[i][j] = false;
    }
}

class Trie {

    private TrieNode root;

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
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.endOfWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.endOfWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }
}

class TrieNode {

    public boolean endOfWord;
    public char val;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {
    }

    public TrieNode(char val) {
        this.val = val;
    }
}
