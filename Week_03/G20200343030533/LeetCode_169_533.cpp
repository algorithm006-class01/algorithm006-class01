//169. 多数元素
// https://leetcode-cn.com/problems/majority-element/description/

//方法1, 用map统计, 40ms
class Solution {
public:
    int majorityElement(vector<int>& nums) {

        unordered_map<int,int> dict;
        for (int i = 0 ;i < nums.size(); i++){
            if (dict.count(nums[i]) == 0 ){
                dict[nums[i]] = 1;
            } else{
                dict[nums[i]]++;
            }
        }
        int max_freq = 0;
        int max_num = 0;
        for (auto it = dict.begin(); it != dict.end(); it++){
            if (it->second > max_freq){
                max_freq = it->second;
                max_num = it->first;
            }
        }
        return max_num;

    }
};

//方法2: 分治方法
//注意输入的high=nums.size()-1
//难点在于merge
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int high = nums.size();
        int res = DC(nums, 0, high-1);
        return res;

    }
    int DC(vector<int>&nums, int low, int high){
        //只有一个元素
        if ( low == high) return nums[low];

        //分割元素, 递归
        int mid  = low + ((high-low) >> 1);
        int left = DC(nums, low,  mid);
        int right= DC(nums, mid+1, high);
        
        //如果左右一致，则合并
        if (left == right) return left;
        //如果不一致, 统计次数
        int leftCount = countNums(left, nums, low, mid);
        int rightCount = countNums(right, nums, mid+1, high);

        return leftCount >  rightCount ? left : right;

    }
    int countNums(int num, vector<int>& nums, int low, int high){
        int count = 0;
        for (int i = low; i <= high; i++){
            if (nums[i] == num) count+=1;
        }
        return count;
    }
};

//方法3:排序,
// 占据了n/2的空间，因此排序后的n/2元素一定是众数
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        return nums[nums.size() / 2];

    }
};

//方法4: 投票法. 不直观，但是很巧妙
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int candidate;
        int count = 0;
        for (auto num : nums){
            if (count == 0){
                candidate = num;
            }
            count += (num == candidate) ?  1 : -1;
        }
        return candidate;

    }
};

