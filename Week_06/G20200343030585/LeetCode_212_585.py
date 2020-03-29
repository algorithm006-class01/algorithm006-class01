# -*- coding: utf-8 -*-
#
# @lc app=leetcode.cn id=212 lang=python
#
# [212] 单词搜索 II
#

# 解题思路
# 1.Trie树
#   1.构建words的字典树
#   在字典树的处理过程中可以简化，直接使用dict的setdefault方法解决赋值和返回
#   2.对boards网格 进行 DFS，四个方向DFS
#   通过字典树过滤掉前缀不符合要求的部分
#   3.题目要求一个词里面不能重复使用字母，所以要记录这一次使用的位置，使用完后要清理
#   这里用set不用dict，因为set和dict本质存储类似，set不存储value所以更快，
#   而且可以用set | {(i,j)}的结构解决回溯问题，避免dict的添加和删除两次操作

# @lc code=start

class Solution(object):
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        trie = {}  # 构造字典树
        for word in words:
            node = trie
            for char in word:
                node = node.setdefault(char, {})
            node['#'] = True

        res = set()
        m = len(board)
        n = len(board[0])
        # cnt = {'cnt':1}

        # DFS
        def dfs(x, y, node, word, used):
            if '#' in node: 
                res.add(word)


            for x1,y1 in [[-1,0], [1,0], [0,1], [0,-1]]:      # 四个方向
                _x,_y = x+x1, y+y1
                if 0 <= _x < m and 0 <= _y < n and board[_x][_y] in node: 
                    if (_x, _y) not in used:
                        # cnt['cnt'] +=1
                        dfs(_x, _y, node[board[_x][_y]], word + board[_x][_y], used | {(_x, _y)})

       
       
        for i in range(m):
            for j in range(n):
                if board[i][j] in trie:  # 可继续搜索
                    dfs(i,j, trie[board[i][j]], board[i][j], {(i,j)})
        # print(cnt)
        return list(res)

if __name__ == "__main__":
    obj = Solution()
    ret = obj.findWords([
        ["b","a","a","b","a","b"],
        ["a","b","a","a","a","a"],
        ["a","b","a","a","a","b"],
        ["a","b","a","b","b","a"],
        ["a","a","b","b","a","b"],
        ["a","a","b","b","b","a"],
        ["a","a","b","a","a","b"]
        ],
        [
            "bbaabaabaaaaabaababaaaaababb",
            "aabbaaabaaabaabaaaaaabbaaaba",
            "babaababbbbbbbaabaababaabaaa",
            "bbbaaabaabbaaababababbbbbaaa",
            "babbabbbbaabbabaaaaaabbbaaab",
            "bbbababbbbbbbababbabbbbbabaa",
            "babababbababaabbbbabbbbabbba",
            "abbbbbbaabaaabaaababaabbabba",
            "aabaabababbbbbbababbbababbaa",
            "aabbbbabbaababaaaabababbaaba",
            "ababaababaaabbabbaabbaabbaba",
            "abaabbbaaaaababbbaaaaabbbaab",
            "aabbabaabaabbabababaaabbbaab",
            "baaabaaaabbabaaabaabababaaaa",
            "aaabbabaaaababbabbaabbaabbaa",
            "aaabaaaaabaabbabaabbbbaabaaa",
            "abbaabbaaaabbaababababbaabbb",
            "baabaababbbbaaaabaaabbababbb",
            "aabaababbaababbaaabaabababab",
            "abbaaabbaabaabaabbbbaabbbbbb",
            "aaababaabbaaabbbaaabbabbabab",
            "bbababbbabbbbabbbbabbbbbabaa",
            "abbbaabbbaaababbbababbababba",
            "bbbbbbbabbbababbabaabababaab",
            "aaaababaabbbbabaaaaabaaaaabb",
            "bbaaabbbbabbaaabbaabbabbaaba",
            "aabaabbbbaabaabbabaabababaaa",
            "abbababbbaababaabbababababbb",
            "aabbbabbaaaababbbbabbababbbb",
            "babbbaabababbbbbbbbbaabbabaa"]
        )
    print(ret)
 
# @lc code=end

