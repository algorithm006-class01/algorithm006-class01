//思路同C，只不过用java写
class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }
        }
        j++;
        return j;
        
    }
}
