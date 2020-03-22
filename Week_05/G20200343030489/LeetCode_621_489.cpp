/*
 * @lc app=leetcode.cn id=621 lang=cpp
 *
 * [621] 任务调度器
 */

// @lc code=start
class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        unordered_map<char,int> map;
        int count=0;
        for(auto e:tasks){
            map[e]++;
            count=max(count,map[e]);
        }
        int res=(count-1)*(n+1);
        for(auto e:map)
            if(e.second==count)
                res++;
        return max((int)tasks.size(),res);
    }
};
// @lc code=end

