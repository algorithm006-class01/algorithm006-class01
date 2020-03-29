import java.util.Set;

/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 *
 * https://leetcode-cn.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (39.31%)
 * Likes:    120
 * Dislikes: 0
 * Total Accepted:    11K
 * Total Submissions: 27.9K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n' +
  '["oath","pea","eat","rain"]'
 *
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * 
 * 示例:
 * 
 * 输入: 
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ⁠ ['o','a','a','n'],
 * ⁠ ['e','t','a','e'],
 * ⁠ ['i','h','k','r'],
 * ⁠ ['i','f','l','v']
 * ]
 * 
 * 输出: ["eat","oath"]
 * 
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * 
 * 提示:
 * 
 * 
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？
 * 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<String>();

        for (int r = 0 ; r < board.length ; r++) {
            for (int c = 0 ; c < board[0].length ; c++) {
                findWordCore(board, r, c, root, result); 
            }
        }

        return result;
    }

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private void findWordCore(char[][] board, int row, int col, TrieNode curNode, List<String> result) {
        int nr = board.length, nc = board[0].length;
        if (row < 0 || row >= nr || col < 0 || col >= nc) return;
        char ch = board[row][col];
        if ('@' == ch || null == curNode.links[ch - 'a']) return;
        
        curNode = curNode.links[ch - 'a'];
        if (null != curNode.word) {  // 遇到word，加入结果集，并置为null，防止重复添加
            result.add(curNode.word);
            curNode.word = null;
        }

        board[row][col] = '@';
        for (int[] dir : dirs){
            findWordCore(board, row + dir[0], col + dir[1], curNode, result);
        }
        board[row][col] = ch;
    }

    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (null == node.links[index])
                    node.links[index] = new TrieNode();
                node = node.links[index];
            }
            node.word = word;
        }
        return root;
    }
    
    class TrieNode {
        TrieNode[] links = new TrieNode[26];
        String word;
    }
}
// @lc code=end
