
// 55. 跳跃游戏
// https://leetcode-cn.com/problems/jump-game/

//贪心法
//算法思想: 从后往前循环，记住能抵达终点的位置
class Solution {
public:
    bool canJump(vector<int>& nums) {
        if ( nums.size() == 0 ) return false;

        int canReach = nums.size() - 1;

        for (int i =nums.size() - 1; i >= 0 ; i--){
            //当前位置所走的步数是否大于最后一个可抵达的位置。
            if ( nums[i] + i >= canReach ){
                canReach =  i;
            }
        }
        return canReach == 0;

    }
};


//回溯代码

/*这是原来的代码, 存在bug
class Solution {
public:
    bool canJump(vector<int>& nums) {

        if (nums.size() == 0 ) return false;

        return DFS(nums, 0);

    }

    bool DFS(vector<int>& nums, int d){
        //递归终止条件
        // 当前位置是0，或者到达矩阵最后一个位置
        if (nums[d] == 0 || d>=nums.size()-1){
            return d>=nums.size() -1 ? true : false; 
        }
        int maxStep = nums[d];
        bool status = true;
        for ( int i = maxStep; i >= 1; i--){
            if (d + i >= nums.size() - 1){
                return true;
            }
            status = DFS(nums, d + i);
        }
        return status;
    }
};

//通过学习官方题解，修改如下
class Solution {
public:
    bool canJump(vector<int>& nums) {

        if (nums.size() == 0 ) return false;

        return DFS(nums, 0);

    }

    bool DFS(vector<int>& nums, int d){
        //递归终止条件
        if (d>=nums.size()-1){
            return true ; 
        }
        int maxStep = nums[d];
        for ( int i = maxStep; i >= 1; i--){
            if (DFS( nums, d +i)){
                return true;
            }
        }
        return false;
    }
};

//代码的问题，是存在大量重复运算，需要进行记忆化，（这就是动态规划了）,但是依旧超出时间
class Solution {
public:
    vector<bool> visited;
    bool canJump(vector<int>& nums) {

        if (nums.size() == 0 ) return false;
        visited = vector<bool>(nums.size(), false);

        return DFS(nums, 0);

    }

    bool DFS(vector<int>& nums, int d){
        //递归终止条件
        if (d>=nums.size()-1){
            return true ; 
        }
        visited[d] = true;
        int maxStep = nums[d];
        for ( int i = maxStep; i >= 1; i--){
            if ( ! visited[d+i] && DFS( nums, d +i)){
                return true;
            }
        }
        return false;
    }
};
*/