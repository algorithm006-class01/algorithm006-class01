public class Solution {
    public int RemoveDuplicates(int[] nums)
    {
        if (nums.Length == 0)
        {
            return 0;
        }
        
        int j = 1;
        int trackInt = nums[0];
        for (int i = 1; i < nums.Length; i++)
        {
            if (nums[i] != trackInt)
            {
                nums[j] = nums[i];
                j++;
                trackInt = nums[i];
            }
        }

        return j;
    }
}