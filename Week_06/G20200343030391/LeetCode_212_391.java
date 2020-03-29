package G20200343030391;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeetCode_212_391 {

    public static void main(String[] args) {
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board =
                {
                        {'o', 'a', 'a', 'n'},
                        {'e', 't', 'a', 'e'},
                        {'i', 'h', 'k', 'r'},
                        {'i', 'f', 'l', 'v'}
                };
        List<String> list = new LeetCode_212_391().findWords(board, words);
        System.out.println(list);

    }

    /**
     * Trie
     * 时间复杂度 O(N * M * 4^k)
     *
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        TrieNode node = root;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                TrieNode trieNode = node.nodes[word.charAt(j) - 'a'];
                if (trieNode == null) {
                    node.nodes[word.charAt(j) - 'a'] = new TrieNode();
                    node = node.nodes[word.charAt(j) - 'a'];
                } else {
                    node = node.nodes[word.charAt(j) - 'a'];
                }
            }
            node.isEnd = true;
            node.val = word;
            node = root;
        }

        int row = board.length;
        int clo = board[0].length;
        int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        boolean[][] visited = new boolean[row][clo];
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < clo; j++) {
                dfs(i, j, row, clo, board, visited, direction, result, root);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(int i, int j, int row, int clo, char[][] board, boolean[][] visited, int[][] direction, HashSet<String> result, TrieNode node) {
        if (i < 0 || i >= row || j < 0 || j >= clo || visited[i][j]) {
            return;
        }
        TrieNode trieNode = node.nodes[board[i][j] - 'a'];
        if (trieNode == null) {
            return;
        }
        visited[i][j] = true;
        if (trieNode.isEnd) {
            result.add(trieNode.val);
        }

        for (int k = 0; k < 4; k++) {
            dfs(i + direction[k][0], j + direction[k][1], row, clo, board, visited, direction, result, trieNode);
        }
        visited[i][j] = false;

    }

    public static class TrieNode {
        TrieNode[] nodes;
        String val;
        boolean isEnd;

        public TrieNode() {
            nodes = new TrieNode[26];
        }
    }
}
