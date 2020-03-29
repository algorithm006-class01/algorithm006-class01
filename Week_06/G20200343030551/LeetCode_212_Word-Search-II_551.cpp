#include <iostream>
#include <vector>
#include <set>

using namespace std;

class Trie
{
public:
    bool is_end;
    Trie *next[26]; // 单词在a - z之间
    Trie()
    {
        is_end = false;
        for (int i = 0; i < 26; ++i) next[i] =NULL;
    }

    void insert(const string &word)
    {
        Trie *t = this;
        for (auto i : word)
        {
            if (t->next[i - 'a'] == nullptr) t->next[i - 'a'] = new Trie();
            t = t->next[i - 'a'];
        }
        t->is_end = true;
    }
};

class Solution
{
    Trie *root;
    int row, col;
    int dx[4] = {0, -1, 0, 1}, dy[4] = {1, 0, -1, 0};
    set<string> aws; // 暂存遍历时的存在的单词，可能会有重复元素，去重用set
    string temp; // 用来存储遍历时生成的中间字符串
    vector<vector<bool>> vis; // 标记是否访问过
public:
    Solution()
    { root = new Trie(); }

    void DFS(int i, int j, const vector<vector<char>> &board, const Trie *t)
    {
        char c = board[i][j];
        temp.push_back(c);
        if (t->next[c - 'a'] == nullptr)
        {
            temp.pop_back();
            // 每次生成字符串时不能访问这次已经访问过的点，但是下一次开始时能访问与上一次重复的点，要重置vis
            vis[i][j] = false;
            return;
        }
        vis[i][j] = true;
        if (t->next[c - 'a']->is_end == true) aws.insert(temp); // 组成前缀树中的一个单词
        for (int k = 0; k < 4; ++k)
        {
            int I = dx[k] + i, J = dy[k] + j;
            if (I >= 0 && I < row && J >= 0 && J < col && vis[I][J] == false)
                DFS(I, J, board, t->next[c - 'a']);
        }
        // 运行到这里重置vis和temp
        vis[i][j] = false;
        temp.pop_back();
    }

    vector<string> findWords(vector<vector<char>> &board, vector<string> &words)
    {
        for (auto s : words) root->insert(s); // 先将单词插入到前缀树中
        row = board.size(), col = board[0].size();
        vis.resize(row);
        for (int i = 0; i < row; ++i)
        {
            vis[i].resize(col);
            fill(vis[i].begin(), vis[i].end(), false);
        }
        for (int i = 0; i < row; ++i) // 对整个图DFS
            for (int j = 0; j < col; ++j)
                DFS(i, j, board, root);
        vector<string> ans(aws.begin(), aws.end()); // set转换为vector
        return ans;
    }
};