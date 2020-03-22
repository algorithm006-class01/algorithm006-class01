package datast.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_212_611 {

    class Solution {

        private Trie trie;

        private boolean[][] visted;

        private Set<String> result = new HashSet<>();

        public List<String> findWords(char[][] board, String[] words) {
            // 构建tire树
            trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }
            int m = board.length;
            int n = board[0].length;
            visted = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(i, j, m, n, board, trie.root);
                }
            }
            return new ArrayList(result);
        }

        private void dfs(int i, int j, int m, int n, char[][] board, TrieNode node) {
            if (i < 0 || j < 0 || i >= m || j >= n || visted[i][j]) return;
            node = node.get(board[i][j]);
            if (node == null) return;
            visted[i][j] = true;
            if (node.isEnd()) result.add(node.getWord());
            dfs(i + 1, j, m, n, board, node);
            dfs(i - 1, j, m, n, board, node);
            dfs(i, j + 1, m, n, board, node);
            dfs(i, j - 1, m, n, board, node);
            visted[i][j] = false;
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
                    if (!node.contains(c)) {
                        node.put(c, new TrieNode());
                    }
                    node = node.get(c);
                }
                node.setEnd();
                node.setWord(word);
            }

            /**
             * Returns if the word is in the trie.
             */
            public boolean search(String word) {
                TrieNode node = searchPrefix(word);
                return node != null && node.isEnd();
            }

            /**
             * Returns if there is any word in the trie that starts with the given prefix.
             */
            public boolean startsWith(String prefix) {
                TrieNode node = searchPrefix(prefix);
                return node != null;
            }

            private TrieNode searchPrefix(String word) {
                TrieNode node = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (!node.contains(c)) {
                        return null;
                    }
                    node = node.get(c);
                }
                return node;
            }

        }

        class TrieNode {

            private TrieNode[] links;

            private int linksLength = 26;

            private boolean end;

            private String word;

            public TrieNode() {
                links = new TrieNode[linksLength];
            }

            private boolean contains(char c) {
                return links[c - 'a'] != null;
            }

            private TrieNode get(char c) {
                return links[c - 'a'];
            }

            private void put(char c, TrieNode node) {
                links[c - 'a'] = node;
            }

            private void setEnd() {
                end = true;
            }

            private boolean isEnd() {
                return end;
            }

            private void setWord(String word) {
                this.word = word;
            }

            private String getWord() {
                return word;
            }
        }


    }
}
