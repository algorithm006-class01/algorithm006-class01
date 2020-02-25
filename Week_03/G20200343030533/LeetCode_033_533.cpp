// https://leetcode-cn.com/problems/search-in-rotated-sorted-array/


//代码比较长度版本
//先确定自己是在那个部分

class Solution{
public:
    int search(vector<int>& nums, int target){
        int low = 0, high = nums.size() - 1;
        
        while ( low <= high){
            int mid = low + (high - low ) / 2;
            if (target == nums[mid]) return mid; //找到了
            //low-mid递增
            if ( nums[low] <= nums[mid]){
                // targe在当前区间里
                if ( target >= nums[low] && target < nums[mid]){
                    high = mid - 1; 
                } else {
                    low = mid + 1; //不在, 说明在mid-high里
                }
            } else{ //分析mid-high
                if ( target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                } else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
};

// 代码2
class Solution {
public:
    int search(vector<int>& nums, int target) {

        int low = 0;
        int high = nums.size() - 1;

        while (low < high) {
            int mid = ( low + high) >> 1;
            if (nums[mid] == target ) return mid;
            if (nums[0] <= nums[mid] && ( target > nums[mid] || target < nums[0] )){
                low = mid + 1;
            }  else if ( target > nums[mid] && target < nums[0]){
                low = mid + 1;
            } else{
                high = mid;
            }
        }
        return low == high && nums[low] == target ? low : - 1;
        }

};