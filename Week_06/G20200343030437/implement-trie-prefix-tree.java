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
            TrieNode trieNode = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!trieNode.containsKey(ch)) {
                    trieNode.childs.add(new TrieNode(ch));
                }
                trieNode = trieNode.get(ch);
            }
            trieNode.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode trieNode = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!trieNode.containsKey(ch)) {
                    return false;
                }
                trieNode = trieNode.get(ch);
            }
            return trieNode.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode trieNode = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                if (!trieNode.containsKey(ch)) {
                    return false;
                }
                trieNode = trieNode.get(ch);
            }
            return true;
        }

        class TrieNode {
            Boolean isEnd = false;
            List<TrieNode> childs = new ArrayList<>();
            char value;

            public TrieNode(){}            
            public TrieNode(char ch) {
                value = ch;
            }

            public Boolean containsKey(char ch) {
                for (TrieNode node : childs) {
                    if (node.value == ch) return true;
                }
                return false;
            }

            public TrieNode get(char ch) {
                for (TrieNode node : childs) {
                    if (node.value == ch) return node;
                }
                return null;
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
