课后作业
001 
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
解题思路:
快指针 慢指针 还有一个标记位用于存放最后一个不一样的元素索引.
注意点:C++一定要注意数组越界问题
参考连接:https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/
解答如下:
class Solution {
public:
int removeDuplicates(vector<int>& nums) {
if(nums.size() ==0) return 0;
int j = 1;
int k = 0;
int N = nums.size();

for (int i =0; i <N ,j< N;){
if (nums[i]!=nums[j]){
nums[i+1] = nums[j];
i++;
k = i;
}
j++;
}
return k+1;
}
};
