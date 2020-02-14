class Solution
{
public:
    void moveZeroes(vector<int> &nums)
    {
        int temp=0;
        for (int j = 0; j < nums.size(); j++)
        {
            if (nums[j]==0)
            {
                temp++;
            }
            else if(temp>0)
            {
                nums[j-temp]=nums[j];
                nums[j]=0;
            }
            
            
        }
    }
};