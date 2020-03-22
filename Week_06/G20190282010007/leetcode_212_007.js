// 题目: 单词搜索2
/**
 * 题目描述：
给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。


 */

 // 解题语言: javaScript

 // 解题

 /**
  * @param {character[][]} board
  * @param {string[]} words
  * @return {string[]}
  */
 var findWords = function (board, words) {
     // 定好4向
     let direction = [[-1, 0], [1, 0], [0, -1], [0,1]]
     // 创建字典树trie
     const trie = {}
     for (const word of words) {
         node = trie
         for (const char of word) {
             if (!node[char]) {node[char] = {}}
             // node[char] = node[char] || {}
             node = node[char]
         }
         node._end = true
     }
     // dfs
     function dfs(board, node, i, j, word) {
         // 将单词放入Set数组中
         if (node._end) {
             res.add(word)
         }
         // 当前逻辑
         const tmp = board[i][j]
         board[i][j] = '@'
         for (const arr of direction) {
             let _i = i + arr[0]
             let _j = j + arr[1]
             if (_i >= 0 && _i < m && _j >= 0 && _j < n && node[board[_i,_j]] && board[_i][_j] !== '@' && board[_i]) {
                 // 根据条件判断是否下探
                 dfs(board, node[board[_i][_j]], _i, _j, word + board[_i][_j])
             }
         }
         // 还原
         board[i][j] = tmp
     }

     // 使用dfs
     const res = new Set()
     const m = board.length
     const n = board[0].length

     for (let i = 0; i < m; i++) {
         for (let j = 0; j < n; j++) {
             if (trie[board[i][j]]) {
                 dfs(board, trie[board[i][j]], i, j, board[i][j])
             }
         }
     }
     return Array.from(res)
 }