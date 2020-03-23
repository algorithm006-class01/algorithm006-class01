package com.jk.work.week06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_212_587 {
    int n;
    int m;
    char[][] board;
    Trie trie;
    Set<String> set = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        n = board.length;
        m = board[0].length;
        int k = 4;
        //生成字典树
        trie = createTrie(words);

        //遍历二维数组
        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < m; j++) {
                dfs(i, j, "", trie.root);
            }
        }
        return new ArrayList<>(set);
    }

    void dfs(int i, int j, String s, Trie.TrieNode node) {
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] == '#') {
            return;
        }
        char ch = board[i][j];
        if (node == null) return;
        if (!node.contains(ch)) return;
        node = node.get(ch);
        s += ch;
        if (node.isEnd) {
            set.add(s);
        }
        //标记是边界防止进入递归后重复调用
        board[i][j] = '#';
        //进入递归
        dfs(i - 1, j, s, node);
        dfs(i + 1, j, s, node);
        dfs(i, j - 1, s, node);
        dfs(i, j + 1, s, node);
        board[i][j] = ch;
    }

    private Trie createTrie(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        return trie;
    }

    class Trie {
        /** Initialize your data structure here. */
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode tn = root;
            for (char ch : word.toCharArray()) {
                if (!tn.contains(ch)) {
                    tn.put(ch, new TrieNode());
                }
                tn = tn.get(ch);
            }
            tn.setIsEnd();
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode tn = root;
            for (char ch : word.toCharArray()) {
                if (!tn.contains(ch)) return false;
                tn = tn.get(ch);
            }
            return tn.getIsEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode tn = root;
            for (char ch : prefix.toCharArray()) {
                if (!tn.contains(ch)) return false;
                tn = tn.get(ch);
            }
            return true;
        }
        class TrieNode {
            TrieNode[] links;
            private final int len = 26;
            private boolean isEnd;
            private String val;

            public TrieNode() {
                links = new TrieNode[26];
            }

            public boolean contains(char ch) {
                return links[ch - 'a'] != null;
            }

            public TrieNode get(char ch) {
                return links[ch - 'a'];
            }

            public void put(char ch, TrieNode tn) {
                links[ch - 'a'] = tn;
            }

            public void setIsEnd() {
                this.isEnd = true;
            }
            public boolean getIsEnd() {
                return this.isEnd;
            }
        }
    }
}
