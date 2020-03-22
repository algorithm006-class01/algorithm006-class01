package datast.trie;

public class LeetCode_208_611 {

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

        class TrieNode {

            private TrieNode[] links;

            private int linksLength = 26;

            private boolean end;

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
        }
    }


}
