/*
 * @lc app=leetcode.cn id=126 lang=cpp
 *
 * [126] 单词接龙 II
 */

// @lc code=start
class Solution
{
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string> &wordList)
    {
        unordered_map<string,int> num;
        vector<vector<string>> res;
        for(auto w:wordList)
            num.insert({w,INT_MAX});
        num[beginWord]=0;
        queue<pair<string,vector<string>>> que;
        que.push({beginWord,{beginWord}});
        while (!que.empty())
        {
            auto n=que.front();
            que.pop();
            string w=n.first;
            auto v=n.second;
            if (w==endWord)
            {
                res.push_back(v);
                continue;
            }
            for (int i = 0; i < w.size(); i++)
            {
                string t=w;
                for (char c='a'; c<='z'; c++)
                {
                    t[i]=c;
                    if(t==w)
                        continue;
                    if(num.find(t)==num.end())
                        continue;
                    if(num[t]<(int)v.size())
                        continue;
                    num[t]=(int)v.size();
                    v.push_back(t);
                    que.push({t,v});
                    v.pop_back();
                }

            }

        }
        return res;
    }
};
// class Solution
// {
// public:
//     vector<vector<string>> findLadders(string beginWord, string endWord, vector<string> &wordList)
//     {
//         vector<vector<string>> ans;
//         unordered_set<string> wordDict(wordList.begin(), wordList.end());
//         vector<string> levDict;
//         while (wordDict.count(endWord) == 0)
//             return ans;
//         queue<vector<string>> q;
//         vector<string> ladder;
//         string curEnd;
//         q.push(vector<string>{beginWord});
//         bool goDeep = true;
//         int minLadderLen = wordList.size();
//         int lev = 1;
//         while (!q.empty())
//         {
//             ladder = q.front();
//             q.pop();

//             if (ladder.size() >= minLadderLen)
//                 break;

//             if (ladder.size() > lev)
//             {
//                 lev++;
//                 for (auto word : levDict)
//                     wordDict.erase(word);
//                 levDict.clear();
//             }

//             curEnd = ladder.back();

//             if (onediff(curEnd, endWord))
//             {
//                 ladder.push_back(endWord);
//                 ans.push_back(ladder);
//                 if (goDeep)
//                 {
//                     minLadderLen = ladder.size();
//                     goDeep = false;
//                 }
//             }

//             for (int i = 0; i < curEnd.length(); i++)
//             {
//                 char ch = curEnd[i];
//                 for (int j = 0; j < 26; j++)
//                 {
//                     curEnd[i] = 'a' + j;
//                     if (wordDict.count(curEnd) == 1)
//                     {
//                         ladder.push_back(curEnd);
//                         q.push(ladder);
//                         ladder.pop_back();
//                         levDict.push_back(curEnd);
//                     }
//                 }
//                 curEnd[i] = ch;
//             }
//         }

//         return ans;
//     }

// private:
//     bool onediff(string a, string b)
//     {
//         int diffs = 0;
//         for (int i = 0; i < b.length(); i++)
//         {
//             if (a[i] != b[i])
//                 diffs++;
//         }
//         if (diffs == 1)
//             return true;
//         return false;
//     }
// };
// @lc code=end
