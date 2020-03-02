题目:模拟行走机器人
di以北为0，顺时针加1，所以是北0，东1，南2，西3
-向左90°时，就是顺时针旋转，（drct + 3）% 4
-向右90°时，就是逆时针旋转90°，相当于顺时针旋转270°，（drct + 1）% 4

int dx[4] = {0,1,0,-1};
int dy[4] = {1,0,-1,0};

表示往x方向移动和往y方向移动时，移动的步数。

解法如下:https://leetcode-cn.com/problems/walking-robot-simulation/solution/874-mo-ni-xing-zou-ji-qi-ren-unordered_set-set-uno/
#include <unordered_set>
自定义一个set
struct pair_hash
{
    template<class T1, class T2>
    std::size_t operator() (const std::pair<T1, T2>& p) const
    {
        auto h1 = std::hash<T1>{}(p.first);
        auto h2 = std::hash<T2>{}(p.second);
        return h1^h2;
    }
};

class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        int dx[4] = {0,1,0,-1};
        int dy[4] = {1,0,-1,0};
        int x = 0, y = 0, di = 0;
        
        unordered_set<pair<int, int>,pair_hash> obstacleSet;
        for(vector<int>obstacle : obstacles){
            obstacleSet.insert(make_pair(obstacle[0],obstacle[1]));
        }
        
        int ans =0;
        for(int cmd : commands){
            if(cmd == -2)
                di = (di +3)%4;
            if(cmd ==-1)
                di = (di +1)%4;
            else{
                for(int k =0; k < cmd;++k){
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    if(obstacleSet.find(make_pair(nx,ny)) == obstacleSet.end()){
                        x = nx;
                        y = ny;
                        ans = max(ans,x*x+y*y);
                    }
                    
                }
            }
        }
        return ans;
    }
};



