class Trie {

    private TrieNode trieNode;

    private class TrieNode {
        private TrieNode[] trieNode;
        private int capacity = 26;
        private boolean end;
        public TrieNode() {
            trieNode = new TrieNode[26];
        }

        public TrieNode get(char c) {
            return trieNode[c - 'a'];
        }

        public TrieNode put(char c) {
            int i = c - 'a';
            if (!containsKey(i)) {
                trieNode[i] = new TrieNode();
            }
            return trieNode[i];
        }

        public boolean containsKey(int i) {
            return trieNode[i] != null;
        }

        public boolean containsKey(char c) {
            return trieNode[c - 'a'] != null;
        }

        public boolean isEnd() {
            return end;
        }

        public void setEnd(boolean flag) {
            end = flag;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        trieNode = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = trieNode;
        for (char c: word.toCharArray()){
            node = node.put(c);
        }
        node.setEnd(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = trieNode;
        for (char c: word.toCharArray()){
            node = node.get(c);
            if (node == null) return false;
        }
        return node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = trieNode;
        for (char c: prefix.toCharArray()){
            node = node.get(c);
            if (node == null) return false;
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