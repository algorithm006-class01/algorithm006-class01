#
# @lc app=leetcode.cn id=127 lang=python
#
# [127] 单词接龙
#
# 1.广度优先遍历
#   1.从beginword开始顺序遍历字典，如果出现一个单词能从begin一步变化到wordlist里面的单词
# 就将这个单词设置为begin单词继续循环
#   2.单词和单词比较只能变化一个字母，就是单词1和单词2只有1个字母的差别，
# 所以比较单词的差别个数就可以
#   3.将所有可能的转化次数都记录下来，比较最小值
# 复杂度分析
# 时间复杂度：O(M*N），其中 M 是单词的长度 N 是单词表中单词的总数。找到所有的变换需要对每个单词做 M次操作。
# 同时，最坏情况下广度优先搜索也要访问所有的 N 个单词。
# 空间复杂度：O(M*N)，要在 all_combo_dict 字典中记录每个单词的 M 个通用状态。访问数组的大小是 N。
# 广搜队列最坏情况下需要存储 N 个单词。

# @lc code=start
from collections import deque
from collections import defaultdict

class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        res = []
        if beginWord == endWord:
            return 0
        if endWord not in wordList:
            return 0
        
        # # 由于单词相同，只需要遍历一次就可以了
        # def changeStep(word1, word2):
        #     change = 0
        #     for i in range(len(word1)):
        #         if word1[i] != word2[i]:
        #             change+=1
        #     return change == 1

        L = len(beginWord)
        #通过单词的通用规则比如hit可以变换为h*t,*it,hi* 等情况找到字典里面所有的word对应关系
        #这样就可以利用索引的方式来查找结果，时间复杂度O(1),这里的两遍循环的时间复杂度是O(n*m),m为单词的长度
        all_combo_dict = defaultdict(list)
        for word in wordList:
            for i in range(L):
                # Key is the generic word
                # Value is a list of words which have the same intermediate generic word.
                all_combo_dict[word[:i] + "*" + word[i+1:]].append(word)

        # Queue for BFS
        queue = deque()
        # current, previous, step
        queue.append([beginWord, 1]) 
        #为了防止出现环，使用访问数组记录
        visited = {beginWord:True}
        while queue:
            current, step = queue.popleft()
            for i in range(L):
                intermediate_word = current[:i] + "*" + current[i+1:]
            
                for node in all_combo_dict[intermediate_word]:
                    if node == endWord:
                        return step + 1
                    if node not in visited:
                        visited[node] = True
                        queue.append([node, step + 1])
                # 避免重复计算
                all_combo_dict[intermediate_word] = []
        
        if len(res) > 0: return min(res)
        return 0
        
        
            
        
        
        
# @lc code=end

