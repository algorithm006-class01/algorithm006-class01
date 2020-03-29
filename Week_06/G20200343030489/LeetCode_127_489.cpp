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
        unordered_set<string> wordS(wordList.begin(),wordList.end());
        if(wordS.count(endWord)==0)
            return 0;
        unordered_set<string> begin({beginWord});
        unordered_set<string> end({endWord});
        int res=2;
        while(!begin.empty()){
            unordered_set<string> next;
            for(auto& word:begin)
                wordS.erase(word);
            for(auto& word:begin){
                for(int i=0;i<word.size();i++){
                    string str=word;
                    for(char c='a';c<='z';c++){
                        str[i]=c;
                        if(wordS.count(str)==0)
                            continue;
                        next.insert(str);
                        if(end.count(str)==0)
                            continue;
                        return res;
                    }
                }
            }
            begin=next;
            if(begin.size()>end.size())
                swap(begin,end);
            res++;
        }
        return 0;
    }
};

// @lc code=end