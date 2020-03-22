#
# @lc app=leetcode id=127 lang=python3
#
# [127] Word Ladder
#
# https://leetcode.com/problems/word-ladder/description/
#
# algorithms
# Medium (27.50%)
# Likes:    2483
# Dislikes: 1014
# Total Accepted:    367.1K
# Total Submissions: 1.3M
# Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
#
# Given two words (beginWord and endWord), and a dictionary's word list, find
# the length of shortest transformation sequence from beginWord to endWord,
# such that:
# 
# 
# Only one letter can be changed at a time.
# Each transformed word must exist in the word list. Note that beginWord is not
# a transformed word.
# 
# 
# Note:
# 
# 
# Return 0 if there is no such transformation sequence.
# All words have the same length.
# All words contain only lowercase alphabetic characters.
# You may assume no duplicates in the word list.
# You may assume beginWord and endWord are non-empty and are not the same.
# 
# 
# Example 1:
# 
# 
# Input:
# beginWord = "hit",
# endWord = "cog",
# wordList = ["hot","dot","dog","lot","log","cog"]
# 
# Output: 5
# 
# Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
# "dog" -> "cog",
# return its length 5.
# 
# 
# Example 2:
# 
# 
# Input:
# beginWord = "hit"
# endWord = "cog"
# wordList = ["hot","dot","dog","lot","log"]
# 
# Output: 0
# 
# Explanation: The endWord "cog" is not in wordList, therefore no possible
# transformation.
# 
# 
# 
# 
# 
#

# @lc code=start
# 自己写的 bfs
from collections import deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        steps = 0
        queue = deque([beginWord])
        visited = set([beginWord])
        word_set = set(wordList)
        while queue:
            size = len(queue)
            steps += 1
            for i in range(size):
                word = queue.popleft()
                if word == endWord:
                    return steps
                next_words = self.find_next(word)
                for next_word in next_words:
                    if next_word not in visited and next_word in word_set:
                        queue.append(next_word)
                        visited.add(next_word)
        return 0


    def find_next(self, word: str):
        words = []
        for i in range(len(word)):
            left, right = word[:i], word[i + 1:]
            for c in 'abcdefghijklmnopqrstuvwxyz':
                if word[i] == c:
                    continue
                new_word = left + c + right
                words.append(new_word)
        
        return words


# 很好的优化思路
#  https://leetcode-cn.com/problems/word-ladder/solution/suan-fa-shi-xian-he-you-hua-javashuang-xiang-bfs23/
# 双端 bfs，每次从节点少的那边搜索
from collections import deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        steps = 0
        if endWord not in wordList or not endWord or not beginWord or not wordList:
            return steps
        wordList.append(beginWord)
        word_set = set(wordList)
        begin_queue, begin_visited = deque([beginWord]), set([beginWord])
        end_queue, end_visited = deque([endWord]), set([endWord])

        while begin_queue and end_queue:
            steps += 1
            if len(begin_queue) <= len(end_queue):
                is_finished = self.visit_word(begin_queue, begin_visited, end_visited, word_set)
                if is_finished: return steps
            else:
                is_finished = self.visit_word(end_queue, end_visited, begin_visited, word_set)
                if is_finished: return steps
        return 0

    def find_next(self, word: str):
        words = []
        for i in range(len(word)):
            left, right = word[:i], word[i + 1:]
            for c in 'abcdefghijklmnopqrstuvwxyz':
                if word[i] == c:
                    continue
                new_word = left + c + right
                words.append(new_word)
        return words

    def visit_word(self, queue, visited, other_visited, word_set):
        size = len(queue)
        for i in range(size):
            word = queue.popleft()
            if word in other_visited:
                return True
            next_words = self.find_next(word)
            for next_word in next_words:
                if next_word not in visited and next_word in word_set:
                    visited.add(next_word)
                    queue.append(next_word)
    
        return False


# @lc code=end

