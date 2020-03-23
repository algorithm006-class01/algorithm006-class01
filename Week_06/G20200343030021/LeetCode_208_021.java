package trie;

/**
 * #### [208. 实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)
 */
public class ImplementTriePrefixTree {
    class Trie {

        class TrieNode {
            public char data;
            public TrieNode[] children = new TrieNode[26];
            public boolean isEndingChar = false;

            public TrieNode(char data) {
                this.data = data;
            }
        }

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode('/');//存储无意义字符
        }

        /**
         * Inserts a word into the trie.
         * 往 Trie 树中插入一个字符串
         */
        public void insert(String word) {
            TrieNode p = this.root;
            for (char i : word.toCharArray()) {
                if (p.children[i - 'a'] == null) {
                    TrieNode newNode = new TrieNode(i);
                    p.children[i - 'a'] = newNode;
                }
                p = p.children[i - 'a'];
            }
            p.isEndingChar = true;
        }


        /**
         * Returns if the word is in the trie.
         * 在Trie树中查找一个字符串
         */
        public boolean search(String word) {
            TrieNode p = this.root;
            for (char i : word.toCharArray()) {
                if (p.children[i - 'a'] == null) {
                    return false; //不存在
                }
                p = p.children[i - 'a'];
            }
            return p.isEndingChar;//为 false ： 不能完全匹配，只是前缀
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         * 在Trie树中查找一个字符串前缀
         */
        public boolean startsWith(String prefix) {
            TrieNode p = this.root;
            for (char i : prefix.toCharArray()) {
                if (p.children[i - 'a'] == null) {
                    return false; //不存在
                }
                p = p.children[i - 'a'];
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
