class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size()==0)
        {
            /* code */return 0;
        }
        int a=0;
        for (int i = 0; i < nums.size(); i++)
        {
            /* code */if (nums[i]!=nums[a])
            {
                /* code */a++;
                nums[a]=nums[i];
            }
            
        }
        return a+1;
        
           
    }
};