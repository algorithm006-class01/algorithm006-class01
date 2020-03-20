package week6.implement_trie_prefix_tree;

public class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
    }

    public boolean containKey(char c){
        return children[c-'a'] != null;
    }

    public void add(char c,TrieNode trieNode){
        children[c-'a'] = trieNode;
    }

    public TrieNode get(char c){
        return children[c-'a'];
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}
