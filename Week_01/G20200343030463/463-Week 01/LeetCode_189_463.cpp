课后作业

002 https://leetcode-cn.com/problems/rotate-array/

解法一:
解题思路:
001 找到最后一个元素,
002 整体元素往后挪一位
003 001和002 循环K次
执行结果:运行超时
class Solution {
public:
void rotate(vector<int>& nums, int k) {
int N = nums.size();
int previous =0;
int temp = 0;
for (int i=0;i<k;k++){
previous = nums[N-1];
for(int j=N-1;j>0;j--){
nums[j] = nums[j-1];
}
nums[0] = previous;
}
}
};


