// 127.单词接龙
// https://leetcode-cn.com/problems/word-ladder/

class Solution{
private:
    //计算两个单词之间的距离
    int wordDist(const string& w1, const string &w2){
        int cnt = 0;
        for (int i = 0; i < w1.size(); i++){
            if (w1[i] != w2[i]) cnt++;
        }
        return cnt;
    }
    //寻找当前单词的所有邻接单词
    vector<string> findAdj(string& target, vector<string>& wordList){
        vector<string> res;
        for (const auto& word : wordList){
            if(wordDist(target, word) == 1){
                res.push_back(word);
            }
        }
        return res;
    }
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList){

        deque<string> de; 
        deque<string> nde; //临近单词队列
        //记录访问过的节点
        unordered_set<string> visited;

        //加入第一个节点
        de.push_back(beginWord);
        visited.insert(beginWord);

        int cnt = 0;
        while(!de.empty () || !nde.empty() ){
            if (de.empty()){
                swap(de, nde);
                cnt++;
            }
            //出队，获取当前word
            auto str = de.front();
            de.pop_front();
            //找到当前单词的所有临近词
            for (auto e : findAdj(str, wordList)){
                if ( e == endWord) return cnt + 2; //临近词就是结束
                if (visited.find(e) == visited.end() ){ //没有访问
                    visited.insert(e);
                    nde.push_back(e);
                }
            }
        }
        return 0;
        
    }
};

/* 提前算好算好距离, 速度可能会慢，因为有些词，访问不到，存在无效计算。
       
        unordered_map<string, vector<string>> m;
        m[beginWord] = findAdj(beginWord, wordList);
        for (auto word : wordList){
            m[word] = findAdj(word, wordList);
        }
*/

//双端BFS
//不再按个计算和其他单词的距离，直接替换单词，看能不能换，能换就继续下去。
class Solution{
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList){
        //加入所有节点，访问过一次，删除一个。
        unordered_set<string> s;
        for (auto &i : wordList) s.insert(i);

        queue<pair<string, int>> q;
        //加入beginword
        q.push({beginWord, 1});

        string tmp; //每个节点的字符
        int step;    //抵达该节点的step

        while ( !q.empty() ){
            if ( q.front().first == endWord){
                return (q.front().second);
            }
            tmp = q.front().first;
            step = q.front().second;
            q.pop();

            //寻找下一个单词了
            char ch;
            for (int i = 0; i < tmp.length(); i++){
                ch = tmp[i];
                for (char c = 'a'; c <= 'z'; c++){
                    //从'a'-'z'尝试一次
                    if ( ch == c) continue;
                    tmp[i] = c ;
                    //如果找到的到
                    if (  s.find(tmp) != s.end() ){
                        q.push({tmp, step+1});
                        s.erase(tmp) ; //删除该节点
                    }
                tmp[i] = ch; //复原
                }
               
            }
        }
        return 0;
    }
};
