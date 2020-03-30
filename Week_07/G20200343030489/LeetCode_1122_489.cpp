/*
 * @lc app=leetcode.cn id=1122 lang=cpp
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        int count=0;
        for(int i=0;i<arr2.size();i++){
            for(int j=count;j<arr1.size();j++){
                if(arr1[j]==arr2[i]){
                    swap(arr1[j],arr1[count]);
                    count++;
                }
            }
        }
        sort(arr1.begin()+count,arr1.end());
        return arr1;
    }
};
// @lc code=end

