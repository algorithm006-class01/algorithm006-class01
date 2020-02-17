class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
       map<int,int> a_map;
       vector<int> b_vec(2,-1);
       for(int i=0;i<nums.size();i++)
       {
           
           if(a_map.count(target-nums[i])>0)
           {
               b_vec[0]=a_map[target-nums[i]];
               b_vec[1]=i;
               break;
           }
          a_map[nums[i]]=i;
       }
       return b_vec;
    }
};
