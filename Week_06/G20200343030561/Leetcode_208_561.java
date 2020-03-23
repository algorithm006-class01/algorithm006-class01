/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) 
                node.put(new TrieNode(), c);
            node = node.get(c);
        }
            
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.containsKey(c))
                node = node.get(c);
            else 
                return false;
        }
        return node != null && node.isEnd();
     }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.containsKey(c))
                node = node.get(c);
            else 
                return false;
        }
        return node != null;
    }

    class TrieNode {
        private TrieNode[] nodes;
        private final int len = 26;
        private boolean isEnd = false;
        public TrieNode() {
            nodes = new TrieNode[len];
        }
        public boolean containsKey (char c) {
            return nodes[c - 'a'] != null;
        }
        public TrieNode get(char c) {
            return nodes[c - 'a'];
        }
        public void put (TrieNode node, char c) {
            nodes[c - 'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

