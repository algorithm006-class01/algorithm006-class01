006 https://leetcode-cn.com/problems/move-zeroes/
解题思路: 将不为0的元素依次放到数组的起始位置直到所有非零元素放置完成,保存最后一个元素的下标,后继元素置为0

class Solution {
public:
void moveZeroes(vector<int>& nums) {
int j =0;
int N = nums.size();

for (int i =0;i<N;i++){
if(nums[i]!=0){
nums[j] = nums[i];
j++;
}
}

for(int i =j;i<N;i++){
nums[i]=0;
}
}
};

