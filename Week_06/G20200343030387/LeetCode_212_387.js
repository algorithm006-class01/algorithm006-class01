/**
1. 对words构建字典树；
2. 对board的每个字符进行四联通的深度优先遍历（dfs）；
3. dfs剪枝：每个新字符加入前，判断是否在当前字典树的下个节点，是则继续遍历，否则不再遍历；
4. 注意对已访问过的字符进行标记，这里将其替换为"@"，待遍历完成后恢复数据；
**/

/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function (board, words) {
    // build trie
    const trie = {}
    for (const word of words) {
        node = trie
        for (const char of word) {
            node[char] = node[char] || {}
            node = node[char]
        }
        node._end = true
    }

    // dfs fn
    function dfs(board, node, i, j, word) {
        if (node._end) {
            res.add(word)
        }
        const tmp = board[i][j]
        board[i][j] = '@'
        for (const arr of [[-1, 0], [1, 0], [0, -1], [0, 1]]) {
            let _i = i + arr[0]
            let _j = j + arr[1]
            if (_i >= 0 && _i < m && _j >= 0 && _j < n && node[board[_i][_j]] && board[_i][_j] !== '@') {
                dfs(board.map(a => a.slice(0)), node[board[_i][_j]], _i, _j, word + board[_i][_j])
            }
        }
        board[i][j] = tmp
    }

    // search board by dfs with each word
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
};
