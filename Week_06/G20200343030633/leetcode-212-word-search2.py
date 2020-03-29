# 利用208的trie 同时对二维数组进行深度遍历
import week06.leetcode_208_trie


class WordTrie(week06.leetcode_208_trie.Trie):
    def findWords(self, board, words):
        trie = {}  # 构造字典树
        for word in words:
            node = trie
            for char in word:
                node = node.setdefault(char, {})
            node['_'] = True

        def dfssearch(x, y, node, pre, visited):  # (i,j)当前坐标，node当前trie树结点，pre前面的字符串，visited已访问坐标
            if '_' in node:  # 已有字典树结束
                res.add(pre)  # 添加答案
            for (di, dj) in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                _i, _j = x + di, y + dj
                if -1 < _i < h and -1 < _j < w and board[_i][_j] in node and (_i, _j) not in visited:  # 可继续搜索
                    dfssearch(_i, _j, node[board[_i][_j]], pre + board[_i][_j], visited | {(_i, _j)})  # dfs搜索

        res, h, w = set(), len(board), len(board[0])
        for i in range(h):
            for j in range(w):
                if board[i][j] in trie:  # 可继续搜索
                    dfssearch(i, j, trie[board[i][j]], board[i][j], {(i, j)})  # dfs搜索

        return res


words = ["oath", "pea", "eat", "rain"]
board = \
    [
        ['o', 'a', 'a', 'n'],
        ['e', 't', 'a', 'e'],
        ['i', 'h', 'k', 'r'],
        ['i', 'f', 'l', 'v']
    ]

wt = WordTrie()
print(wt.findWords(board, words))
