/**
 * 208. 实现 Trie (前缀树)
 * 难度
 * 中等
 * <p>
 * 225
 * <p>
 * 收藏
 * <p>
 * 分享
 * 切换为英文
 * 关注
 * 反馈
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */
public class Trie {

    /**
     * 标识是否到此是一个完整的单词
     */
    private boolean endOfWord;

    /**
     * 直接儿子结点
     */
    private Trie[] children;

    /**
     * 代表的字符
     */
    private Character letter;

    public Trie() {
        this(null);
    }

    public Trie(Character letter) {
        this.letter = letter;
        this.endOfWord = false;
        // 26 个英文单词
        this.children = new Trie[26];
    }

    /**
     * 向字典树插入单词
     */
    public void insert(String word) {
        Trie p = this;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            int index = letter - 'a';
            if (p.children[index] == null) {
                p.children[index] = new Trie(letter);
            }
            p = p.children[index];
        }

        p.endOfWord = true;
    }

    /**
     * 查看单词是否在字典树中存在
     */
    public boolean search(String word) {
        Trie p = this;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            int index = letter - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return p.endOfWord;
    }

    /**
     * 查看字典树中是否存在 word 开头的单词
     */
    public boolean startsWith(String word) {
        Trie p = this;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            int index = letter - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return true;
    }
}
