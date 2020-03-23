#include <unordered_map>
#include <vector>
#include <queue>

using namespace std;

class Solution
{
public:
    //解法2：双向bfs
    int minMutation(string start, string end, vector<string> &bank)
    {
        //1:建立hashmap表，顺便去掉重复元素
        unordered_map<string, int> mp;
        for (const auto &b:bank)mp[b] = 0;

        //2:排除极端情况，end不在基因库中
        if (mp.count(end) == 0)return -1;

        //3:bfs的初始化工作
        queue<string> q1({start}), q2({end});//前向队列，后向队列
        int step = 0;
        const char table[4] = {'A', 'C', 'G', 'T'};//基因的字符
        //或1表示前向队列由前往后遍历，或2表示后向队列由后向前遍历，每次我们选用较小的队列进行遍历
        for (mp[start] |= 1, mp[end] |= 2; q1.size() && q2.size(); ++step)//每遍历完一次，步长+1
        {
            bool first = q1.size() < q2.size();
            queue<string> &q = first ? q1 : q2;//选择较小的队列进行遍历节约时间
            int flag = first ? 1 : 2;//此次遍历的方式

            for (int n = q.size(); n--; q.pop())
            {
                string &temp = q.front();
                if (mp[temp] == 3)return step;//两个队列碰头，返回步长
                for (int i = 0; i < temp.size(); ++i)
                {
                    for (int j = 0; j < 4; ++j)
                    {
                        string s = temp;
                        if (s[i] == table[j])continue;//重复字符，跳出循环，寻找下一个字符
                        s[i] = table[j];
                        if (mp.count(s) == 0 || mp[s] & flag)continue;//该单词不在map中或该单词已经被遍历过了，跳出循环，寻找下一个单词
                        mp[s] |= flag;//标记该单词已经被遍历过了
                        q.push(s);
                    }
                }
            }
        }
        return -1;
    }
};
