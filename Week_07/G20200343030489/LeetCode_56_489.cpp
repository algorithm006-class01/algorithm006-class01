/*
 * @lc app=leetcode.cn id=56 lang=cpp
 *
 * [56] 合并区间
 */

// @lc code=start
// class Solution {
// public:
//     vector<vector<int>> merge(vector<vector<int>>& intervals) {
//         vector<vector<int>> res;
//         if(intervals.empty())
//             return res;
//         sort(intervals.begin(),intervals.end(),[&,this](vector<int> &v1,vector<int> &v2){return v1.front()<v2.front();});
//         int size=intervals.size();
//         for(int i=0;i<size;i++){
//             auto tmp=intervals[i];
//             while(i+1<size&&tmp.back()>=intervals[i+1].front()){
//                 ++i;
//                 tmp.back()=max(tmp.back(),intervals[i].back());
//             }
//             res.push_back(tmp);
//         }
//         return res;     
//     }
// };
class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> res;
        if(intervals.size()==0||intervals.size()==1)
            return intervals;
        int u=0,v=0;
        sort(intervals.begin(),intervals.end());
        while(v<intervals.size()){
            if(intervals[v][0]>intervals[u][1]){
                res.emplace_back(intervals[u]);
                u=v;
            }else if(intervals[v][1]<=intervals[u][1])
                ++v;
            else{
                intervals[u][1]=intervals[v][1];
                ++v;
            }
        }
        res.emplace_back(intervals[u]);
        return res;   
    }
};
// @lc code=end

