课后作业

005 https://leetcode-cn.com/problems/two-sum/
解法一:
暴力求解
解法二:利用unordered_map key是num[i] value是i
如果target-nums[i]在map中找得到那么就返回value 和 i

class Solution {
public:
vector<int> twoSum(vector<int>& nums, int target) {

unordered_map <int,int> newM;

for(int i =0; i < nums.size();i++){
if(newM.find(target-nums[i]) != newM.end()){
return {newM[target-nums[i]],i};
}
newM[nums[i]] = i; 
}

return {};
}
};

