
//https://leetcode-cn.com/problems/walking-robot-simulation/description/

/*做题过程:
审题:
1. 一共有2类指令，一种是改变方向，一种是移动。第一个问题如何记住当前移动方向
2. 空间中存在障碍物，移动的时候会碰壁。如何分析自己会碰壁？

第一个问题的解决思路，让我想到了之前的dx, dy，建立一个方向变量，每次变更位置后，传递方向变量对应位置
于是我写下了下面这部分代码，先保证在没有障碍之前，我的程序能够运行
*/

class Solution {
private:
    //up, right, down, left
    int dx[4] = { 0, 1,  0, -1};
    int dy[4] = { 1, 0, -1,  0};
    int end[2] = {0, 0} ;//初始位置
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        int towards = 0;//默认是上
        for (auto c : commands){
            if ( c == -2){
                towards = (towards+4-1) % 4;
            } else if ( c == -1 ){
                towards = (towards+1) % 4;
            } else{
                end[0] += c * dx[towards];
                end[1] += c * dy[towards];
            }
        }
        return end[0] * end[0] + end[1] * end[1];
    

    }
};

// 但是发现代码有问题，结果不正确，我以为是行走部分的代码错了，仔细检查，发现是审题不当，
// 要求返回的是返回从原点到机器人的最大欧式距离的平方。而不是最后一个位置，
// 修改后
class Solution {
private:
    //up, right, down, left
    int dx[4] = { 0, 1,  0, -1};
    int dy[4] = { 1, 0, -1,  0};
    int end[2] = {0, 0} ;//初始位置
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        int towards = 0;//默认是上
        int maxpos = 0;
        for (auto c : commands){
            if ( c == -2){
                towards = (towards+4-1) % 4;
            } else if ( c == -1 ){
                towards = (towards+1) % 4;
            } else{
                end[0] += c * dx[towards];
                end[1] += c * dy[towards];
                maxpos = max(end[0] * end[0] + end[1] * end[1], maxpos);
            }
        }
        return maxpos 
    

    }
};

/* 下一个问题，是如何处理障碍物。
或者是说，什么时候要考虑障碍物？
假如有[2,4],[0,8]两个障碍物,
当我在[1,1]的时候，无论往哪里走都不会被限制住。
当我在[0,4]的时候，往上会遇到[0,8] 往右会遇到[2,4]. 
一开始我的想法是，根据要走的方向来筛选可能会遇到的障碍物，但是仔细思考，觉得这样子会很复杂，代码量很大。
不如直接把路走了（也就是规划好可能的位置），然后分析和预期终点的x或者y相同的可能障碍。
进一步，我又想到，我们可以记录前一个位置的x和y，
- 如果x没变化，那我们就寻找x相同的障碍
- 如果y没变化，那我们就寻找y相同的障碍
*/

class Solution {
private:
    //up, right, down, left
    int dx[4] = { 0, 1,  0, -1};
    int dy[4] = { 1, 0, -1,  0};
    int end[2] = {0, 0} ;//初始位置
    int prev[2] = {0,0} ;//前一个位置
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        int towards = 0;//默认是上
        int maxpos = 0;
        for (auto c : commands){
            if ( c == -2){
                towards = (towards+4-1) % 4;
            } else if ( c == -1 ){
                towards = (towards+1) % 4;
            } else{
                end[0] += c * dx[towards];
                end[1] += c * dy[towards];
                if (end[0] == prev[0]){ 
                    //上下移动，寻找x相同的障碍
                    for ( auto it : obstacles){
                        if (it[0] == end[0]){
                            end[1] = min(end[1], it[1]);
                        }
                    }
                } else {
                    //寻找y相同的障碍 
                    for ( auto it : obstacles){
                        if (it[1] == end[1]){
                            end[0] = min(end[0], it[0]);
                        }
                    }
                }
                prev[0] = end[0], prev[1] = end[1];
                maxpos = max(end[0] * end[0] + end[1] * end[1], maxpos);
            }
        }
        return maxpos ;
    

    }
};
// 然后上面代码，在运行的时候又出现了问题，
// 向上/下移动，并不需要考虑左/右边的障碍，同理，向左/右移动。也不需要考虑上/下障碍
// 想到就很头大，于是我将这部分调整为指导代码进行了抽象，单独领出来思考
class Solution {
private:
    //up, right, down, left
    int dx[4] = { 0, 1,  0, -1};
    int dy[4] = { 1, 0, -1,  0};
    int end[2] = {0, 0} ;//初始位置
    int prev[2] = {0,0} ;//前一个位置
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        int towards = 0;//默认是上
        int maxpos = 0;
        for (auto c : commands){
            if ( c == -2){
                towards = (towards+4-1) % 4;
            } else if ( c == -1 ){
                towards = (towards+1) % 4;
            } else{
                end[0] += c * dx[towards];
                end[1] += c * dy[towards];
                meetObstacle(end, prev, obstacles);
                prev[0] = end[0], prev[1] = end[1];
                maxpos = max(end[0] * end[0] + end[1] * end[1], maxpos);
            }
        }
        return maxpos ;
    

    }
    void meetObstacle(int *end, int*prev, vector<vector<int>>& obstacles){
       
    }
};

/*问题就在于meetObstacle函数的定义,
然而实在想不通，

我就看题解了,有2点收获
1. 不用循环进行查找，而是用set 
2. 先把所有的路都走遍一遍，看我们抵达位置是不是障碍点，如果不是障碍点，就更新。

if (obstacleSet.find(make_pair(nx, ny)) == obstacleSet.end()) {
    x = nx;
    y = ny;
    ans = max(ans, x*x + y*y);
}
*/

//最终代码如下
class Solution {

public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
    //up, right, down, left
        int dx[4] = { 0, 1,  0, -1};
        int dy[4] = { 1, 0, -1,  0};
        int x = 0, y = 0 ;//初始位置
        int towards = 0;//默认是上
        int maxpos = 0;

        set<pair<int, int>> pos;
        for (auto it : obstacles){
            pos.insert( {it[0], it[1]} );
        }
        for (auto c : commands){
            if ( c == -2){
                towards = (towards+4-1) % 4;
            } else if ( c == -1 ){
                towards = (towards+1) % 4;
            } else{
                for (int k = 0; k < c; ++k){
                    int nx = x + dx[towards];
                    int ny = y + dy[towards];
                    if (pos.find({nx,ny}) == pos.end()){
                        x = nx;
                        y = ny;
                        maxpos = max(maxpos, x*x + y*y);
                    }
                }
            }
        }
        return maxpos ;
    

    }

};