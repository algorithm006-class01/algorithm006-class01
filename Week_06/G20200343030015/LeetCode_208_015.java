package G20200343030015.week_06;

/**
 * Created by majiancheng on 2020/3/22.
 */

/**
 * 208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 */
public class LeetCode_208_015 {
    private TrieNode root;

    /** Initialize your data structure here. */
    public LeetCode_208_015() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }

            node = node.get(c);
        }

        node.setEnd(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode endNode = this.searchPrefix(word);

        return endNode != null && endNode.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode endNode = this.searchPrefix(prefix);

        return endNode != null;
    }


    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!node.containsKey(c)) {
                return null;
            }

            node = node.get(c);
        }

        return node;
    }
}

class TrieNode {

    private TrieNode[] links;

    private final int R = 26;

    private boolean end;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public boolean isEnd() {
        return this.end;
    }
}
