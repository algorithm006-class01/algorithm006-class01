package com.study.week06;

/**
 * @author Abner
 * @date 2020/3/22 21:45
 * @email songkd90@163.com
 * @description 实现 Trie 前缀树
 */
public class LeetCode_2_429 {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            // 当前字母字符
            char currentChar = word.charAt(i);
            // Trie 当前层节点不包含此字符，则在此节点创建新的 TrieNode 节点
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            // 将节点切换到下一层
            node = node.get(currentChar);
        }
        // 单词字母遍历完毕，设置最后一层节点状态为 isEnd
        node.setEnd();
    }

    // 根据前缀搜索 Trie
    public TrieNode prefixSearch(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            // 当前层字符
            char currentChar = word.charAt(i);
            // 如果节点中无匹配字符，则返回未找到（空）
            if (!node.containsKey(currentChar)) {
                return null;
            }
            // 进入下一层节点
            node = node.get(currentChar);
        }
        // 返回搜索的结果
        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        // 全词搜索，要完全匹配，即每一层节点的字母都对应，且最终 idEnd 状态为 true
        // 基于 prefixSearch()
        TrieNode node = prefixSearch(word);
        // 非空且 isEnd 为 true
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        // 基于 prefixSearch()
        TrieNode node = prefixSearch(prefix);
        // 前缀匹配搜索，只要 prefix 的所有字母都匹配后，得到的节点不为空，则搜索成功
        return node != null;
    }
}

class TrieNode {

    private TrieNode[] links;

    private final int SIZE = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[SIZE];
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

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
