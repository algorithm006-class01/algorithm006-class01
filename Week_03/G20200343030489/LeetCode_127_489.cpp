/*
 * @lc app=leetcode.cn id=127 lang=cpp
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution
{
public:
    int ladderLength(string beginWord, string endWord, vector<string> &wordList)
    {
        unordered_set<string> dict(wordList.begin(), wordList.end()), head, tail, *phead, *ptail;
        if (dict.find(endWord) == dict.end())
            return 0;
        head.insert(beginWord);
        tail.insert(endWord);
        int ladder = 2;
        while (!head.empty() && !tail.empty())
        {
            if (head.size() < tail.size())
            {
                phead = &head;
                ptail = &tail;
            }
            else
            {
                phead = &tail;
                ptail = &head;
            }
            unordered_set<string> tmp;
            for (auto it = phead->begin(); it != phead->end(); it++)
            {
                string word = *it;
                for (int i = 0; i < word.size(); i++)
                {
                    char t = word[i];
                    for (int j = 0; j < 26; j++)
                    {
                        word[i] = 'a' + j;
                        if (ptail->find(word) != ptail->end())
                        {
                            return ladder;
                        }
                        if (dict.find(word) != dict.end())
                        {
                            tmp.insert(word);
                            dict.erase(word);
                        }
                    }
                    word[i] = t;
                }
            }
            ladder++;
            phead->swap(tmp);
        }
        return 0;
    }
};

// @lc code=end