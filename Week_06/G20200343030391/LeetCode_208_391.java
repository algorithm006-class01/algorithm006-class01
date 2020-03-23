package G20200343030391;


public class LeetCode_208_391 {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("a");
        boolean apple = trie.search("a");// 返回 true
        System.out.println(apple);
//        boolean app = trie.search("app");// 返回 false
//        System.out.println(app);
        boolean app1 = trie.startsWith("a");// 返回 true
        System.out.println(app1);
//        trie.insert("app");
//        boolean app2 = trie.search("app");// 返回 true
//        System.out.println(app2);
    }


    public static class Trie {

        private TrieNode trieNode;

        /** Initialize your data structure here. */
        public Trie() {
            this.trieNode = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = this.trieNode;
            for (int i = 0; i < word.length(); i++) {
                if (!node.containKey(word.charAt(i))) {
                    node.put(word.charAt(i), new TrieNode());
                }
                node = node.get(word.charAt(i));
            }
            node.setEnd();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = this.trieNode;
            for (int i = 0; i < word.length(); i++) {
                if (!node.containKey(word.charAt(i))) {
                    return false;
                }
                node = node.get(word.charAt(i));
            }
            return node.isEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = this.trieNode;
            for (int i = 0; i < prefix.length(); i++) {
                if (!node.containKey(prefix.charAt(i))) {
                    return false;
                }
                node = node.get(prefix.charAt(i));
            }
            return true;
        }

    }
    public static class TrieNode{
        TrieNode[] links;
        boolean isEnd;

        public TrieNode() {
            this.links = new TrieNode[26];
        }

        public boolean containKey(char c) {
            return this.links[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return this.links[c - 'a'];
        }

        public void put(char c, TrieNode node) {
            links[c - 'a'] = node;
        }

        public void setEnd(){
            this.isEnd = true;
        }

        public boolean isEnd(){
            return this.isEnd;
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
