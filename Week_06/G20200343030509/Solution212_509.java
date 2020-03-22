package com.leetcode.week06;

/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

import java.util.ArrayList;
import java.util.List;

class Solution212_509 {
    public static void main(String[] args) {
        long startTime=System.nanoTime(); //获取开始时间

        Solution212_509 sol = new Solution212_509();
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};

        System.out.println(sol.findWords(board, words));

        long endTime=System.nanoTime(); //获取结束时间
        System.out.println( "程序运行时间： " + (endTime-startTime) + "ns");
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0) return null;

        List<String> res = new ArrayList<>();

        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, root, res);
            }
        }

        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
        char ch = board[i][j];
        if (ch == '#' || node.next[ch - 'a'] == null) return;
        node = node.next[ch - 'a'];
        if (node.word != null) {
            res.add(node.word);
            // 删除避免重复
            node.word = null;
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, node, res);
        if (j > 0) dfs(board, i, j-1, node, res);
        if (i < board.length - 1) dfs(board, i+1, j, node, res);
        if (j < board[0].length - 1) dfs(board, i, j+1, node, res);
        board[i][j] = ch;
    }


    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieNode node = root;
            for (char ch: word.toCharArray()) {
                int i = ch - 'a';
                if (node.next[i] == null) {
                    node.next[i] = new TrieNode();
                }
                node = node.next[i];
            }
            node.word = word;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}