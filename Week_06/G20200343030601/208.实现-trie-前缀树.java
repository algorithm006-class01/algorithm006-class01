/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (65.15%)
 * Likes:    225
 * Dislikes: 0
 * Total Accepted:    28K
 * Total Submissions: 42.8K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n' +
  '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 
 * 示例:
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");   
 * trie.search("app");     // 返回 true
 * 
 * 说明:
 * 
 * 
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * 
 * 
 */

// @lc code=start
class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    // 时间复杂度：O(m) m为键长
    // 空间复杂度：O(m) 最坏时，新插入键和Trie树中没有公共前缀，需新添加m个节点
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {  // 如果该字符不存在Trie中，则插入
                node.put(ch, new TrieNode());
            }
            node = node.get(ch); // 取出该分支（即使是刚插入的）
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    // 时间复杂度：O(m) 每一步搜索一个键字符
    // 空间复杂度：O(1)
    public boolean search(String word) {
        // TrieNode node = root;
        // for (int i = 0; i < word.length(); i++) {
        //     char ch = word.charAt(i);
        //     if (!node.containsKey(ch)) return false;
        //     node = node.get(ch);
        // }
        // return node.isEnd();

        TrieNode node = searchPrefix(word);
        return null != node && node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    // 时间复杂度：O(m) 每一步搜索一个键字符
    // 空间复杂度：O(1)
    public boolean startsWith(String prefix) {
        // TrieNode node = root;
        // for (int i = 0; i < prefix.length(); i++) {
        //     char ch = prefix.charAt(i);
        //     if (!node.containsKey(ch)) return false;
        //     node = node.get(ch);
        // }
        // return null != node;

        return null != searchPrefix(prefix);
    }

    // 写完search和startWith，发现出了最后判断之外，其他语句均相同，提取公用函数
    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!node.containsKey(ch)) return null;
            node = node.get(ch);
        }
        
        return node;
    }
}

class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return null != links[ch - 'a'];
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
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

