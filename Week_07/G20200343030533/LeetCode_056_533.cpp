/*
C++,排序；
根据区间左边界排序；
如果下一个区间的左边界小于当前区间的右边界，合并；循环
*/

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        if (intervals.size() == 0 || intervals.size() == 1) return intervals;
        
        int u = 0, v = 0;
        vector<vector<int>> ans;
        //1 二维数组排序
        std::sort(intervals.begin(), intervals.end());
        //2. 双指针遍历
        while (v < intervals.size()) { 
            if (intervals[v][0] > intervals[u][1]) {
                ans.emplace_back(intervals[u]);
                u = v;
            } else if (intervals[v][1] <= intervals[u][1]) {
                ++ v;
            } else {
                intervals[u][1] = intervals[v][1];
                ++ v;
            }
        }
        //特殊情况处理
        ans.emplace_back(intervals[u]);
        return ans;
    }
};

/*参考
ttps://leetcode-cn.com/problems/merge-intervals/solution/c-ji-yu-two-points-he-pai-xu-de-jian-ji-shi-xian-f/
*/