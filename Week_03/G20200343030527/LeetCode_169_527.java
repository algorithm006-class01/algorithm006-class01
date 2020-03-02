class MajorityElement {
    public int majorityElement(int[] nums) {
        int key = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == key)
                count++;
            else
                count--;
            if(count <= 0)
            {
                key = nums[i + 1];
            }
        }
        return key;
    }
}