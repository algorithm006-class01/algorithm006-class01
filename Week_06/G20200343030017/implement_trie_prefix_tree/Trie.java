package week6.implement_trie_prefix_tree;

public class Trie {
    TrieNode trieNode;
    /** Initialize your data structure here. */
    public Trie() {
        trieNode = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = trieNode;
        for (int n=0;n<word.length();n++){
            if (!node.containKey(word.charAt(n))){
                node.add(word.charAt(n),new TrieNode());
            }
            node = node.get(word.charAt(n));
        }
        node.setEnd(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = trieNode;
        for (int n=0;n<word.length();n++){
            if (node.containKey(word.charAt(n))){
                node = node.get(word.charAt(n));
            }else{
                return false;
            }
        }
        return node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = trieNode;
        for (int n=0;n<prefix.length();n++){
            if (node.containKey(prefix.charAt(n))){
                node = node.get(prefix.charAt(n));
            }else{
                return false;
            }
        }
        return true;
    }
}
