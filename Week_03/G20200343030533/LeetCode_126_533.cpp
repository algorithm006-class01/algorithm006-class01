// 126. 单词接龙 II
// https://leetcode-cn.com/problems/word-ladder-ii/

//和127相似，只不过这次要把可能路径都输出
// 和层次遍历类似，不是单个单个出队，而不是一起出队。
class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {

        vector<vector<string>> res;// 输出结果
        unordered_set<string> dict(wordList.begin(), wordList.end()); //记录节点
        if ( dict.find(endWord) == dict.end()) return res;//没有结果

        queue<vector<string>> q;
        q.push({beginWord}); //加入初始值

        while ( ! q.empty() ){
            vector<string> path; //路径
            int s = q.size(); //处理当前队列的所有节点
            vector<string> newWords; //添加当前队列所有节点的访问节点
            while ( s--) { 
                path = q.front();
                q.pop();
                //如果路径的最后一个word就是终点，增加记录
                if (path.back() == endWord) {
                    res.push_back(path);
                }
                string word = path.back();
                for ( int i = 0 ; i < word.size(); i++ ){
                    char tmp = word[i];
                    for ( char ch = 'a'; ch <= 'z'; ch++){
                        if ( word[i] == ch) continue;
                        word[i] = ch;
                        //关键部分，如果能找到下一个词
                        if ( dict.find(word) != dict.end() ){
                            vector<string> newPath (path.begin(), path.end());
                            newPath.push_back(word);
                            q.push(newPath);
                            newWords.push_back(word); //记录访问的节点
                        }
                    }
                    word[i] = tmp;
                }
            }
            //在队列结束之后
            for (string w : newWords){
                    dict.erase(w);
            }
        }

        return res;

    }
};